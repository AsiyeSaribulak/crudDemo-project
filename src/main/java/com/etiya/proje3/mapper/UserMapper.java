package com.etiya.proje3.mapper;

import com.etiya.proje3.dto.UserDto;
import com.etiya.proje3.entity.Users;
import org.mapstruct.*;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ACCESSOR_ONLY
        )
public interface UserMapper {


    UserDto entityToUserDto(Users user);
    Users dtoToUserEntity(UserDto userDto);
    List<UserDto> userEntityToUserDto(List<Users> entityList);

    List<Users> userDtoToUserEntity(List<UserDto> entityList);
    void updateUsersFromDto(UserDto newUserDto, @MappingTarget Users oldUsers);

}
