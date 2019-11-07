package com.elte.alkfejl.controllers;

import com.elte.alkfejl.entities.Label;
import com.elte.alkfejl.repositories.LabelRepository;
import com.elte.alkfejl.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("label")
public class LabelController {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("")
    public ResponseEntity<Iterable<Label>> getAll() {
        return new ResponseEntity(labelRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Label> get(@PathVariable long id) {
        Optional<Label> label = labelRepository.findById(id);
        if (!label.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(label.get());
    }

    @PostMapping("")
    public ResponseEntity<Label> update(@RequestBody Label entity) {
        entity.setCreatedBy(authenticatedUser.getUser());
        entity.setUpdatedBy(authenticatedUser.getUser());
        return ResponseEntity.ok(labelRepository.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Label> update(@PathVariable Long id, @RequestBody Label label) {
        Optional<Label> oLabel = labelRepository.findById(id);
        if (oLabel.isPresent()) {
            label.setId(id);
            label.setUpdatedBy(authenticatedUser.getUser());
            return ResponseEntity.ok(labelRepository.save(label));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Label> delete(@PathVariable Long id) {
        Optional<Label> issue = labelRepository.findById(id);
        if (!issue.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        labelRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
