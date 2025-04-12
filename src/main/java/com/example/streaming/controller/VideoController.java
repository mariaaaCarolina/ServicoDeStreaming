package com.example.streaming.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.streaming.model.Videos;
import com.example.streaming.service.VideosService;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideosService videosService;

    public VideoController(VideosService videosService) {
        this.videosService = videosService;
    }

    @GetMapping
    public List<Videos> listar() {
        return videosService.listar();
    }

    @PostMapping
    public ResponseEntity<Videos> criar(@RequestBody Videos video) {
        return ResponseEntity.status(HttpStatus.CREATED).body(videosService.salvar(video));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videos> buscar(@PathVariable Long id) {
        return videosService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        videosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
