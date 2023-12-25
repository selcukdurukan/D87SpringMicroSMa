package com.ba.boost.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProfileRequestDto {

    @NotNull
    private Long authId;
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    private String token;
}
