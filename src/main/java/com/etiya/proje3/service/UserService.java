package com.etiya.proje3.service;

import com.etiya.proje3.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDto save(UserDto userDto);
    List<UserDto> getall();
    Map<String, Boolean> delete(Long id);
    UserDto update(Long id, UserDto userDto);

    UserDto getById(Long id);

}
