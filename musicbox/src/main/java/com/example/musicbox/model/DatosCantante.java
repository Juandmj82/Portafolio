package com.example.musicbox.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosCantante(
        @JsonAlias("artist") Artist artist
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Artist(
            @JsonAlias("name") String nombre,
            @JsonAlias("url") String url
    ) {}
}