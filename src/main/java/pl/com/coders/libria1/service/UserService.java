package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.UserView;
import pl.com.coders.libria1.controller.request.UserCreateRequest;
import pl.com.coders.libria1.domain.User;
import pl.com.coders.libria1.mapper.UserMapper;
import pl.com.coders.libria1.repository.UserRepository;

import java.util.Optional;

@Service
//TODO add tests
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserView getByLogin(String login) {
        Optional<User> userOptional = userRepository.findByLogin(login);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return userMapper.toView(user);
        } else {
            return null;
        }
    }

    public UserView createUser(UserCreateRequest userCreateRequest) {
        User newUser = userMapper.toEntity(userCreateRequest);
        return userMapper.toView(userRepository.save(newUser));
    }

    public UserView updateUser(UserView userView) {
        User existingUser = userRepository.findById(userView.getId()).orElseThrow();
        existingUser.setLogin(userView.getLogin());
        existingUser.setPassword(userView.getPassword());
        existingUser.setEmail(userView.getEmail());
        return userMapper.toView(userRepository.save(existingUser));
    }

    public void deleteUser(String login) {
        userRepository.deleteByLogin(login);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}