package org.jangid.repository;

import org.jangid.model.House;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HouseRepository {

    private final Map<Integer, House> store = new HashMap<>();
    private int idCounter = 1;

    public House save(House house){
        if(house.getId()==null){
            house.setId(idCounter++);
        }
        store.put(house.getId(), house);
        return house;
    }

    public Optional<House> findById(Integer id){
        return Optional.ofNullable(store.get(id));
    }

    public List<House> findAll() {
        return new ArrayList<>(store.values());
    }


}
