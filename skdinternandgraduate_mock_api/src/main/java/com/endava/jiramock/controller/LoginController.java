package com.endava.jiramock.controller;


import com.endava.jiramock.model.SessionModel;
import com.endava.jiramock.model.User;
import com.endava.jiramock.repository.UserRepository;
import com.endava.jiramock.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserRepository userRepository;

    private final SessionService sessionService;

    @Autowired
    public LoginController(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService = sessionService;
    }

    @RequestMapping(value = "/rest/login/session", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionModel> loginSession(@RequestBody User userModel) {
        SessionModel sessionModel;
        User user = userRepository.findByUsername(userModel.getUsername());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            if (!user.getPassword().equals(userModel.getPassword())) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            } else {
                sessionModel = new SessionModel();
                sessionService.insertSession(sessionModel);
                return new ResponseEntity<>(sessionModel, HttpStatus.OK);
            }

        }
    }
}