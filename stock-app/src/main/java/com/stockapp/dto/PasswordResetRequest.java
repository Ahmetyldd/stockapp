package com.stockapp.dto;

import lombok.Data;

import javax.validation.constraints.Size;

import static com.stockapp.constants.ErrorMessage.PASSWORD2_CHARACTER_LENGTH;
import static com.stockapp.constants.ErrorMessage.PASSWORD_CHARACTER_LENGTH;

@Data
public class PasswordResetRequest {

    private String email;

    @Size(min = 6, max = 16, message = PASSWORD_CHARACTER_LENGTH)
    private String password;

    @Size(min = 6, max = 16, message = PASSWORD2_CHARACTER_LENGTH)
    private String password2;
}
