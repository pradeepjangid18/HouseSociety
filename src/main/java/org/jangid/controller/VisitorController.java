package org.jangid.controller;

import lombok.RequiredArgsConstructor;
import org.jangid.enums.RequestAction;
import org.jangid.model.VisitorRequest;
import org.jangid.service.ResidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VisitorController {

    private final ResidentService residentService;

    @GetMapping("/pending/{residentId}")
    public List<VisitorRequest> pending(@PathVariable int residentId) {
        return residentService.pendingRequests(residentId);
    }

    @PostMapping("/act/{residentId}/{requestId}")
    public VisitorRequest act(@PathVariable int residentId, @PathVariable int requestId, @RequestParam RequestAction action) {
        return residentService.actOnRequest(residentId, requestId, action);
    }
}
