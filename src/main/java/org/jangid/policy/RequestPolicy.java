package org.jangid.policy;

import org.jangid.enums.RequestAction;
import org.jangid.enums.RequestStatus;

import java.util.List;

public interface RequestPolicy {
    RequestStatus nextStatus(RequestStatus current, RequestAction action);
    List<RequestAction> possibleActions(RequestStatus current);
}
