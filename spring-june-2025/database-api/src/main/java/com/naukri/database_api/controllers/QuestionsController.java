package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/questions")

public class QuestionsController {
    QuestionRepo questionRepo;

    @Autowired
    public QuestionsController(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @PostMapping("/save")
    public ResponseEntity<Questions> create(@RequestBody Questions questions) {
        questionRepo.save(questions);
        return new ResponseEntity<>(questions, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questions> findById(@PathVariable UUID id) {
        Questions questions = questionRepo.findById(id).orElse(null);
        return new ResponseEntity<>(questions, HttpStatus.OK);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Questions>> findAll() {
        List<Questions> questions = questionRepo.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Questions questions) {
        questionRepo.save(questions);
        return new ResponseEntity<>(questions, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@PathVariable UUID id) {
        questionRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}


}
