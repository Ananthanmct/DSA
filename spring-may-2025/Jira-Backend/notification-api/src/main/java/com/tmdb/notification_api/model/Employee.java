package com.tmdb.notification_api.model;

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
    String status;
    Organization organization;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
