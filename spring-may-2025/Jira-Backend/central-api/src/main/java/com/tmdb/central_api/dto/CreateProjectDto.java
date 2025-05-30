package com.tmdb.central_api.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateProjectDto {
    String name;
    String description;
    UUID orgId;
}
