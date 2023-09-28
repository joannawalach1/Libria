package pl.com.coders.libria1.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping
    public Account auth() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return new Account(login);
    }
}
