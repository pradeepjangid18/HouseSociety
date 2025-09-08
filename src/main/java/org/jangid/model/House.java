package org.jangid.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class House {

    private Integer Id;
    private int societyId;
    private List<Resident> residentList;

    public House(int societyId){
        this.societyId = societyId;
        this.residentList = new ArrayList<>();
    }
}
