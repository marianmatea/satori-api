package com.satori.service;

import com.satori.dto.UserAddDto;
import com.satori.dto.UserPageDto;
import com.satori.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    UserPageDto getAllPagination(Integer pageNo);

    User createUser(UserAddDto userAddDto);

    User getUser(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
