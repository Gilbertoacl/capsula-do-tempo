package com.gilberto.capsula_do_tempo.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record NovaCapsulaDTO(
        String nome,
        String email,
        String mensagem,
        LocalDate dataEntrega,
        MultipartFile imagem
) {
}
