package com.tmdb.central_api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {
    UUID id;
    String name;
    String description;
    List<Employee> employees;
    Organization organization;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
