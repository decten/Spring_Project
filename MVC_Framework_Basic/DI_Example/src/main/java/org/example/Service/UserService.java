package org.example.Service;

import org.example.annotation.Inject;
import org.example.annotation.Service;

@Service
public class UserService {
    private final UserService userService;

    @Inject
    public UserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
