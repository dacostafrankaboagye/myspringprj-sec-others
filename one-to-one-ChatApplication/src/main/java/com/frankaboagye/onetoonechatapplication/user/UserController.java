package com.frankaboagye.onetoonechatapplication.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user.addUser")
    @SendTo("/topic/user")
    public User addUser(@Payload User user) {
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/user.disconnectUser")
    @SendTo("/topic/user")
    public User disconnectUser(@Payload User user) {
        userService.disconnectUser(user);
        return user;
    }

    @GetMapping("/user.users")
    @SendTo("/topic/user")
    public ResponseEntity<List<User>> finConnectedUsers() {
        return ResponseEntity.ok(userService.getConnectedUsers());
    }
}
