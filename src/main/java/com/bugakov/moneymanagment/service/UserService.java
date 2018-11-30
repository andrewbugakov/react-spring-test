package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.User;

import java.util.List;
import java.util.Optional;

public class UserService implements Service<User, UserService.UserDto> {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User find(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User update(Long id, UserDto userDto) {
        User user = userDao.findById(id);
        setValuesFromDto(userDto, user);
        userDao.update(user);
        return user;
    }

    @Override
    public User create(UserDto userDto) {
        User user = new User();
        setValuesFromDto(userDto, user);
        userDao.create(user);
        return user;
    }

    @Override
    public void delete(Long id){
        userDao.delete(id);
    }

    private void setValuesFromDto(UserDto userDto, User user) {
        userDto.city.ifPresent(user::setCity);
        userDto.country.ifPresent(user::setCountry);
        userDto.nickname.ifPresent(user::setNickname);
        userDto.password.ifPresent(user::setPassword);
    }

    static class UserDto implements Dto {
        private Optional<String> nickname;
        private Optional<String> country;
        private Optional<String> city;
        private Optional<String> password;

        public Optional<String> getNickname() {
            return nickname;
        }

        public void setNickname(Optional<String> nickname) {
            this.nickname = nickname;
        }

        public Optional<String> getCountry() {
            return country;
        }

        public void setCountry(Optional<String> country) {
            this.country = country;
        }

        public Optional<String> getCity() {
            return city;
        }

        public void setCity(Optional<String> city) {
            this.city = city;
        }

        public Optional<String> getPassword() {
            return password;
        }

        public void setPassword(Optional<String> password) {
            this.password = password;
        }
    }
}
