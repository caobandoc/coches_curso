package com.caoc.coches.controller;

import com.caoc.coches.domain.dto.MarcaCocheDto;
import com.caoc.coches.domain.service.IMarcaCocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marcaCoche")
@RequiredArgsConstructor
public class MarcaCocheController {

    private final IMarcaCocheService marcaCocheService;

    @GetMapping
    public ResponseEntity<List<MarcaCocheDto>> getAll() {
        return ResponseEntity.ok(marcaCocheService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaCocheDto> getMarcaCocheById(@PathVariable int id) {
        return ResponseEntity.of(marcaCocheService.getMarcaCocheById(id));
    }

    @PostMapping
    public ResponseEntity<MarcaCocheDto> save(@RequestBody MarcaCocheDto marcaCocheDto) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(marcaCocheService.save(marcaCocheDto));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<MarcaCocheDto> update(@RequestBody MarcaCocheDto marcaCocheDto) {
        return ResponseEntity.of(marcaCocheService.update(marcaCocheDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return new ResponseEntity<>(marcaCocheService.delete(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
