package pl.com.coders.libria1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.controller.request.UserCreateRequest;
import pl.com.coders.libria1.service.UserService;

@RestController
@RequestMapping("/user")
//TODO add tests
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{login}")
    public UserView getByLogin(@PathVariable String login) {
        return userService.getByLogin(login);
    }

    @PostMapping
    public UserView create(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @DeleteMapping("/{login}")
    public void delete(@PathVariable String login) {
        userService.deleteUser(login);
    }

    @PutMapping
    public UserView update(@RequestBody UserView userView) {
        return userService.updateUser(userView);
    }
}
