package com.gilberto.capsula_do_tempo.controller;

import com.gilberto.capsula_do_tempo.dto.NovaCapsulaDTO;
import com.gilberto.capsula_do_tempo.models.Capsula;
import com.gilberto.capsula_do_tempo.service.CapsulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/capsulas")
@RequiredArgsConstructor
public class CapsulaController {

    private final CapsulaService service;

    @PostMapping
    public ResponseEntity<Capsula> criarCapsula (@ModelAttribute NovaCapsulaDTO req){
        try {
            Capsula capsula = service.salvarCapsula(req);
            return ResponseEntity.ok(capsula);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
