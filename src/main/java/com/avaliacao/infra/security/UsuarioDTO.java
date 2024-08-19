package com.avaliacao.infra.security;


public record UsuarioDTO(

    Long id,
    String username,
    String email,
    String tipo

) {}