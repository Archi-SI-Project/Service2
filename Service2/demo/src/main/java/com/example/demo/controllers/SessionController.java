package com.example.demo.controllers;

import com.example.demo.Service.SessionService;
import com.example.demo.persistance.Session;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/session")
public class SessionController {
    private final SessionService sessionService;
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @PreAuthorize("permitAll()")
    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public void addSession(@RequestBody Session session) {
        sessionService.addSession(session);
    }

}
