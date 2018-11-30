package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.ORMHelper;
import com.bugakov.moneymanagment.service.UserService.UserDto;
import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class UserServiceTest {
//    UserService userService;
//    String defaultCity = "City";
//    String defaultCountry = "Country";
//    String defaultNickname = "nickname";
//    String defaultPassword = "password";
//
//    @Before
//    public void setUp() throws Exception {
//        UserDao userDao = new UserDao(ORMHelper.entityManager());
//        userService = new UserService(userDao);
//    }
//
//    @Test
//    public void testCreate() {
//        UserDto userDto = getUserDtoWithFields();
//        User user = userService.create(userDto);
//        Assert.assertNotNull(user);
//        userService.delete(user.getId());
//        User user1 = userService.find(user.getId());
//        Assert.assertNull(user1);
//    }
//
//    private UserDto getUserDtoWithFields() {
//        return getUserDto(of(defaultCity), of(defaultCountry), of(defaultNickname), of(defaultPassword));
//    }
//
//    @Test
//    public void testUpdate() {
//        User user = userService.create(getUserDtoWithFields());
//        Assert.assertNotNull(user);
//        User foundUser = userService.find(user.getId());
//        Assert.assertNotNull(foundUser);
//        String testNickname = "testNickname";
//        String testPassword = "testPassword";
//        UserDto userDto = getUserDto(empty(), empty(), of(testNickname), of(testPassword));
//        User update = userService.update(user.getId(), userDto);
//        Assert.assertEquals(update.getPassword(), testPassword);
//        Assert.assertEquals(update.getNickname(), testNickname);
//        Assert.assertEquals(update.getCity(), defaultCity);
//        Assert.assertEquals(update.getCountry(), defaultCountry);
//        userService.delete(user.getId());
//    }
//
//    private UserDto getUserDto(
//            Optional<String> city, Optional<String> country,
//            Optional<String> nickname, Optional<String> password) {
//        UserDto userDto = new UserDto();
//        userDto.setCity(city);
//        userDto.setCountry(country);
//        userDto.setNickname(nickname);
//        userDto.setPassword(password);
//        return userDto;
//    }
}
