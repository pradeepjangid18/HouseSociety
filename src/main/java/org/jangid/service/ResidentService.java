package org.jangid.service;

import lombok.RequiredArgsConstructor;
import org.jangid.enums.RequestAction;
import org.jangid.enums.RequestStatus;
import org.jangid.enums.VisitorType;
import org.jangid.model.Resident;
import org.jangid.model.VisitorRequest;
import org.jangid.policy.ApprovalPolicyFactory;
import org.jangid.policy.RequestPolicy;
import org.jangid.repository.ResidentRepository;
import org.jangid.repository.VisitorRequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ResidentService {

    private final ResidentRepository residentRepository;
    private final VisitorRequestRepository visitorRequestRepository;

    public List<VisitorRequest> pendingRequests(int residentId) {
        Resident resident = residentRepository.findById(residentId).orElseThrow(() -> new NoSuchElementException("Resident not found"));
        List<VisitorRequest> requestList = new ArrayList<>();
        for (VisitorRequest request : visitorRequestRepository.findAll()) {
            if (request.getHouseId() == resident.getHouseId() && request.getStatus().equals(RequestStatus.PENDING)) {
                requestList.add(request);
            }
        }

        return requestList;
    }

    public VisitorRequest actOnRequest(int residentId, int requestId, RequestAction requestAction) {
        Resident resident = residentRepository.findById(residentId).orElseThrow(() -> new NoSuchElementException("Resident not found"));
        VisitorRequest request = visitorRequestRepository.findById(residentId).orElseThrow(() -> new NoSuchElementException("Request not found"));
        if (request.getHouseId() != resident.getHouseId()) {
            throw new SecurityException("houseId mismatch");
        }

        // TODO - best part, how this policy design is used
        RequestPolicy requestPolicy = ApprovalPolicyFactory.of(request.getVisitorType());
        request.setActedByResidentId(residentId);
        request.setStatus(requestPolicy.nextStatus(request.getStatus(), requestAction));
        request.setActedAt(System.currentTimeMillis());
        visitorRequestRepository.save(request);
        return request;
    }
}
