package com.github.throyer.todoapp.domain.models;

import com.github.throyer.todoapp.domain.entities.User;
import com.github.throyer.todoapp.domain.exceptions.IncorrectCredentialsException;
import com.github.throyer.todoapp.domain.repositories.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class Session {

    private final UserRepository repository;

    private User user;

    public Session(UserRepository repository) {
        this.repository = repository;
    }

    public void login(String email, String password) {
        var optional = repository.findByEmail(email);

        if (optional.isEmpty()) {
            throw new IncorrectCredentialsException();
        }

        var user = optional.get();

        if (user.getPassword().equals(password)) {
            this.user = user;
            return;
        }

        throw new IncorrectCredentialsException();
    }

    public void logout() {
        this.user = null;
    }

    public Optional<User> user() {
        return Optional.ofNullable(this.user);
    }
}
