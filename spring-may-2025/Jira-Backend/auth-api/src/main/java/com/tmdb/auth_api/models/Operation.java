package com.tmdb.auth_api.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Operation {
    UUID id;
    String name;
    String description;
}