package org.jangid.policy;

import org.jangid.enums.VisitorType;

public class ApprovalPolicyFactory {

    public static RequestPolicy of(VisitorType visitorType){
        switch (visitorType) {
            case DELIVERY :
                return new DeliveryRequestPolicy();
            case VISITING_HELP:
            case GUEST:
            default:
                return new CommonRequestPolicy();
        }
    }

}
