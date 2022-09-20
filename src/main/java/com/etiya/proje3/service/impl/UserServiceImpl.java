package com.etiya.proje3.service.impl;

import com.etiya.proje3.dto.UserDto;
import com.etiya.proje3.entity.Users;
import com.etiya.proje3.mapper.UserMapper;
import com.etiya.proje3.repository.UsersRepository;
import com.etiya.proje3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository userRepositroy;

    private UserMapper mapper
            = Mappers.getMapper(UserMapper.class);
    @Override

    public UserDto save(UserDto userDto) {
        Users user=userRepositroy.save(mapper.dtoToUserEntity(userDto));
        return mapper.entityToUserDto(user);
    }

    @Override
    public List<UserDto> getall() {
        return userRepositroy.findAll()
                .stream()
                .map(user -> mapper.entityToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Boolean> delete(Long id)
        throws ConfigDataResourceNotFoundException{
            Users users = userRepositroy.findById(id).orElseThrow(() -> new RuntimeException( "kişi bulunamadı::"+id));
            userRepositroy.delete(users);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }



     /*
     *
     *
     *  */

    @Override
     public UserDto update(Long id, UserDto newUserDto){
        Users user = userRepositroy.findById(id).orElseThrow(() -> new RuntimeException( "kişi bulunamadı::"+id));
        mapper.updateUsersFromDto(newUserDto,user);
        userRepositroy.save(user);
        return mapper.entityToUserDto(user);
    }

    @Override
    public UserDto getById(Long id) {
        Optional<Users> user=userRepositroy.findById(id);
        return user.map(this.mapper::entityToUserDto).orElseThrow(()-> new RuntimeException("kişi bulunamadı::"+ id));
    }
}


