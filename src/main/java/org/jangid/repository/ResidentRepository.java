package org.jangid.repository;

import org.jangid.model.Resident;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ResidentRepository {

    private final Map<Integer, Resident> store = new HashMap<>();
    private int idCounter = 1;

    public Resident save(Resident resident){
        if(resident.getId() == null){
            resident.setId(idCounter++);
        }
        store.put(resident.getId(), resident);
        return resident;
    }

    public Optional<Resident> findById(Integer id){
        return Optional.ofNullable(store.get(id));
    }

    public List<Resident> findAll() {
        return new ArrayList<>(store.values());
    }
}
