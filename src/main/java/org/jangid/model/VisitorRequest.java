package org.jangid.model;

import lombok.Getter;
import lombok.Setter;
import org.jangid.enums.RequestStatus;
import org.jangid.enums.VisitorType;

@Getter
@Setter
public class VisitorRequest {

    private Integer Id;
    private int houseId;
    private int societyId;
    private String visitorName;
    private VisitorType visitorType;
    private RequestStatus status;

    private int actedByResidentId;
    private long actedAt;

    public VisitorRequest(int houseId, int societyId, String visitorName, VisitorType visitorType) {
        this.houseId = houseId;
        this.societyId = societyId;
        this.visitorName = visitorName;
        this.visitorType = visitorType;
        this.status = RequestStatus.PENDING;
    }
}
