package dev.louisa.springbatchdemo.dto.mapper;

import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.model.Movie;

public class DtoMapper {
    public static XmlMovieDto mapToXml(Movie movie) {
        XmlMovieDto movieDto = new XmlMovieDto();
        movieDto.setRemark(movie.getRemark());
        movieDto.setDirector(movie.getDirector());
        movieDto.setTitle(movie.getTitle());
        movieDto.setGenre(movie.getGenre());

        return movieDto;
    }
}
