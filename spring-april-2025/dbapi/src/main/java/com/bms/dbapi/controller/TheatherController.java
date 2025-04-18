package com.bms.dbapi.controller;

import com.bms.dbapi.models.Theather;
import com.bms.dbapi.repository.TheatherRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/theather")
public class TheatherController {

    @Autowired
    TheatherRepositorty theatherRepositorty;

    @PostMapping("/create")
    public ResponseEntity createTheather(@RequestBody Theather theather){
        theatherRepositorty.save(theather);
        return new ResponseEntity(theather, HttpStatus.CREATED);
    }
}
