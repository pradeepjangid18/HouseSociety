package org.jangid.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resident {

    private Integer Id;
    private String name;
    private int houseId;
    private int societyId;

    public Resident(String name, int houseId, int societyId){
        this.name = name;
        this.houseId = houseId;
        this.societyId = societyId;
    }
}
