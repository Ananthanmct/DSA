package com.tmdb.auth_api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    UUID id;
    String firstName;
    String lastName;
    String email;
    String password;
    Organization organization;
    List<Role> roles;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
