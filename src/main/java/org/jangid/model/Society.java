package org.jangid.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Society {

    private Integer Id;
    private String name;
    private List<House> houseList;

    public Society(String name) {
        this.name = name;
        this.houseList = new ArrayList<>();
    }

}
