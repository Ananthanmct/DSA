package com.tmdb.central_api.dto;

import com.tmdb.central_api.models.Operation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OperationListDto {
    List<Operation> operationList;
}

