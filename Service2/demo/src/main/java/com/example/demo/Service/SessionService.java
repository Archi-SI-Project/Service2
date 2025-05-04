package com.example.demo.Service;

import com.example.demo.persistance.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    public void addSession(Session session) {
        sessionRepository.save(session);
    }
}
