package org.jangid.repository;

import org.jangid.model.VisitorRequest;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VisitorRequestRepository {

    private final Map<Integer, VisitorRequest> store = new HashMap<>();
    private int idCounter = 1;

    public VisitorRequest save(VisitorRequest request) {
        if (request.getId() == null) {
            request.setId(idCounter++);
        }
        store.put(request.getId(), request);
        return request;
    }

    public Optional<VisitorRequest> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<VisitorRequest> findAll() {
        return new ArrayList<>(store.values());
    }
}
