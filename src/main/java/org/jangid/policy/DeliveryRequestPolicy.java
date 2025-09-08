package org.jangid.policy;

import org.jangid.enums.RequestAction;
import org.jangid.enums.RequestStatus;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeliveryRequestPolicy implements RequestPolicy {
    @Override
    public RequestStatus nextStatus(RequestStatus current, RequestAction action) {
        if (current == RequestStatus.PENDING) {
            if (action == RequestAction.APPROVE) return RequestStatus.APPROVED;
            if (action == RequestAction.DENY) return RequestStatus.DENIED;
            if (action == RequestAction.LEAVE_AT_GATE) return RequestStatus.LEFT_AT_GATE;
        }
        throw new IllegalStateException("Invalid action" + action);
    }

    @Override
    public List<RequestAction> possibleActions(RequestStatus current) {
        return current == RequestStatus.PENDING ? Arrays.asList(RequestAction.APPROVE, RequestAction.DENY, RequestAction.LEAVE_AT_GATE) : Collections.emptyList();
    }
}
