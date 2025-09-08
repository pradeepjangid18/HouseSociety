package org.jangid.service;

import lombok.RequiredArgsConstructor;
import org.jangid.enums.VisitorType;
import org.jangid.model.House;
import org.jangid.model.VisitorRequest;
import org.jangid.repository.HouseRepository;
import org.jangid.repository.VisitorRequestRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final VisitorRequestRepository visitorRequestRepository;
    private final HouseRepository houseRepository;

    public VisitorRequest createRequest(int securityId, int houseId, String visitorName, VisitorType visitorType) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new NoSuchElementException("house not found"));
        VisitorRequest request = new VisitorRequest(houseId, securityId, visitorName, visitorType);
        visitorRequestRepository.save(request);
        return request;
    }
}
