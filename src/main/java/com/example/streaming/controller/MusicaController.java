package com.example.streaming.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.streaming.model.Musicas;
import com.example.streaming.service.MusicasService;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicasService musicasService;

    public MusicaController(MusicasService musicaService) {
        this.musicasService = musicaService;
    }

    @GetMapping
    public List<Musicas> listar() {
        return musicasService.listar();
    }

    @PostMapping
    public ResponseEntity<Musicas> criar(@RequestBody Musicas musica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicasService.salvar(musica));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musicas> buscar(@PathVariable Long id) {
        return musicasService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        musicasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
