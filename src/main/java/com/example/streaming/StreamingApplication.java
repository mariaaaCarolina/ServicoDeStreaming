package com.example.streaming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.streaming.model.Musicas;
import com.example.streaming.model.Playlist;
import com.example.streaming.model.Usuario;
import com.example.streaming.model.Videos;
import com.example.streaming.repository.MusicasRepository;
import com.example.streaming.repository.PlaylistRepository;
import com.example.streaming.repository.UsuarioRepository;
import com.example.streaming.repository.VideosRepository;

@SpringBootApplication
public class StreamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamingApplication.class, args);
    }

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner runner(
            UsuarioRepository usuarioRepo,
            MusicasRepository musicaRepo,
            VideosRepository videoRepo,
            PlaylistRepository playlistRepo) {
        return args -> {

            // criando usuários
            Usuario usuario1 = new Usuario(null, "João Silva", "joao@email.com", new ArrayList<>());
            Usuario usuario2 = new Usuario(null, "Maria Oliveira", "maria@email.com", new ArrayList<>());
            Usuario usuario3 = new Usuario(null, "Carlos Souza", "carlos@email.com", new ArrayList<>());
            usuario1 = usuarioRepo.save(usuario1);
            usuario2 = usuarioRepo.save(usuario2);
            usuario3 = usuarioRepo.save(usuario3);

            // criando músicas
            Musicas musica1 = new Musicas(null, "Música A", "Pop", "https://musica-a.com", new ArrayList<>());
            Musicas musica2 = new Musicas(null, "Música B", "Rock", "https://musica-b.com", new ArrayList<>());
            Musicas musica3 = new Musicas(null, "Música C", "Jazz", "https://musica-c.com", new ArrayList<>());
            Musicas musica4 = new Musicas(null, "Música D", "Eletrônica", "https://musica-d.com", new ArrayList<>());
            musica1 = musicaRepo.save(musica1);
            musica2 = musicaRepo.save(musica2);
            musica3 = musicaRepo.save(musica3);
            musica4 = musicaRepo.save(musica4);

            // criando vídeos
            Videos video1 = new Videos(null, "Vídeo A", "Clipe musical", "https://video-a.com", new ArrayList<>());
            Videos video2 = new Videos(null, "Vídeo B", "Documentário", "https://video-b.com", new ArrayList<>());
            Videos video3 = new Videos(null, "Vídeo C", "Filme", "https://video-c.com", new ArrayList<>());
            Videos video4 = new Videos(null, "Vídeo D", "Filme 2", "https://video-d.com", new ArrayList<>());
            video1 = videoRepo.save(video1);
            video2 = videoRepo.save(video2);
            video3 = videoRepo.save(video3);
            video4 = videoRepo.save(video4);

            // criando playlists
            List<Musicas> musicas1 = Arrays.asList(musica1, musica2);
            List<Videos> videos1 = Arrays.asList(video1, video2);
            Playlist playlist1 = new Playlist(null, "Playlist 1", usuario1, videos1, musicas1);
            playlist1 = playlistRepo.save(playlist1);

            List<Musicas> musicas2 = Arrays.asList(musica3, musica4);
            List<Videos> videos2 = Arrays.asList(video3, video4);
            Playlist playlist2 = new Playlist(null, "Playlist 2", usuario2, videos2, musicas2);
            playlist2 = playlistRepo.save(playlist2);

            List<Musicas> musicas3 = Arrays.asList(musica1, musica3);
            List<Videos> videos3 = Arrays.asList(video2, video4);
            Playlist playlist3 = new Playlist(null, "Playlist 3", usuario3, videos3, musicas3);
            playlist3 = playlistRepo.save(playlist3);

            // adicionando playlists aos usuários e salvando
            usuario1.getPlaylists().add(playlist1);
            usuario2.getPlaylists().add(playlist2);
            usuario3.getPlaylists().add(playlist3);
            usuarioRepo.save(usuario1);
            usuarioRepo.save(usuario2);
            usuarioRepo.save(usuario3);

            System.out.println("Usuários, músicas, vídeos e playlists criados com sucesso!");
        };
    }

}
