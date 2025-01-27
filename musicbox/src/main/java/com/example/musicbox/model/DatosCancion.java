package com.example.musicbox.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosCancion(
        @JsonAlias("results") Results results
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Results(
            @JsonAlias("trackmatches") TrackMatches trackmatches
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TrackMatches(
            @JsonAlias("track") List<Track> track
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Track(
            @JsonAlias("name") String name,
            @JsonAlias("url") String url,
            @JsonAlias("listeners") String listeners,
            @JsonAlias("artist") String artist
    ) {}
}