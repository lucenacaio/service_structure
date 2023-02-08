package br.com.lucenacaio.structure.mapper;

import br.com.lucenacaio.structure.domain.User;
import br.com.lucenacaio.structure.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    @Mapping(target = "password", source = "password")
    User toEntity(UserDTO userDTO, String password);

}
