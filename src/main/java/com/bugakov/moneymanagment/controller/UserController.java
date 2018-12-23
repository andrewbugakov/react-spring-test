package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.UserDto;
import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/users")
public class UserController implements Controller<User, UserDto> {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @RequestMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userDao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userDao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody  UserDto userDto) {
        User user = userDao.findById(id);
        setValuesFromDto(userDto, user);
        userDao.update(user);

        return ResponseEntity.ok(user);
    }

    @Override
    @RequestMapping(method = POST)
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        User user = new User();
        setValuesFromDto(userDto, user);
        userDao.create(user);
        return ResponseEntity.ok(user);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        userDao.delete(id);
    }

    private void setValuesFromDto(UserDto userDto, User user) {
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setNickname(userDto.getNickname());
        user.setPassword(userDto.getPassword());
    }

}
