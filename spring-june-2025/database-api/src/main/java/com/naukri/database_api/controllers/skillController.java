package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/skills")
public class skillController {
    SkillRepo skillRepo;
    @Autowired
    public skillController(SkillRepo skillRepo)
    {
        this.skillRepo= skillRepo;
    }
    @PostMapping("/save")
    public ResponseEntity<Skill> create (@RequestBody Skill skill)
    {
        skillRepo.save(skill);
        return new ResponseEntity<>(skill, HttpStatus.CREATED);
    }
    @GetMapping("/get/{skillName}")
    public ResponseEntity <Skill>getSkillByName(@PathVariable String skillName)
    {
        Skill skills = skillRepo.findByName(skillName);
        return new ResponseEntity<>(skills,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Skill> findById (@PathVariable UUID id)
    {
        Skill skills = skillRepo.findById (id).orElse(null);
        return new ResponseEntity<>(skills,HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity <List<Skill>> findAll()
    {
        List<Skill> skills = skillRepo.findAll();
        return new ResponseEntity<>(skills,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody  Skill skills)
    {
      skillRepo.save(skills)  ;
      return new ResponseEntity(skills,HttpStatus.CREATED);
    }
    @DeleteMapping("/Delete")
    public ResponseEntity delete(@PathVariable UUID id)
    {
        skillRepo.deleteById (id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
