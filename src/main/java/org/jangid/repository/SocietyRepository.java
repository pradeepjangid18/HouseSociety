package org.jangid.repository;

import org.jangid.model.Society;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SocietyRepository {

    // final store, that means either initialised during declaration or by constructor
    private final Map<Integer, Society> store = new HashMap<>();
    private int idCounter = 1;

    public Society save(Society society){
        if(society.getId() == null){
            society.setId(idCounter++);
        }
        store.put(society.getId(), society);
        return society;
    }

    public Optional<Society> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Society> findAll() {
        return new ArrayList<>(store.values());
    }
}
