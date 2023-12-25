package com.ba.boost.mapper;

import com.ba.boost.dto.request.RegisterRequestDto;
import com.ba.boost.dto.response.RegisterResponseDto;
import com.ba.boost.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);


    Auth toRegisterRequestDto(final RegisterRequestDto dto);

    @Mapping(source = "id", target = "authId")
    RegisterResponseDto fromAuth(final Auth auth);
}
