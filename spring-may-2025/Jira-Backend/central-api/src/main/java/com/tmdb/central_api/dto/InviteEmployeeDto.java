package com.tmdb.central_api.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InviteEmployeeDto {
    String firstName;
    String lastName;
    String email;
    String password;
    UUID orgId;
    List<UUID> roles;
}
