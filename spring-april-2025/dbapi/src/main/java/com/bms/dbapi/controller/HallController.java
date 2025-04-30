package com.bms.dbapi.controller;

import com.bms.dbapi.models.Hall;
import com.bms.dbapi.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/hall")
public class HallController {

    @Autowired
    HallRepository hallRepository;

    @PostMapping("/create")
    public ResponseEntity createHall(@RequestBody Hall hall){
        hallRepository.save(hall);
        return new ResponseEntity(hall, HttpStatus.OK);
    }
}
