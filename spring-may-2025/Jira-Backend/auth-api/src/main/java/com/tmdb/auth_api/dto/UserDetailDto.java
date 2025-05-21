package com.tmdb.auth_api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailDto {
    String email;
    String password;
    String role;
}
