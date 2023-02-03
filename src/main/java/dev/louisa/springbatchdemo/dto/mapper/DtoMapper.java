package dev.louisa.springbatchdemo.dto.mapper;

import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.model.Movie;

public class DtoMapper {

    public static XmlMovieDto map(Movie movie) {
        XmlMovieDto xmlMovieDto = new XmlMovieDto();
        xmlMovieDto.setRemark(movie.getRemark());
        xmlMovieDto.setDirector(movie.getDirector());
        xmlMovieDto.setTitle(movie.getTitle());
        xmlMovieDto.setGenre(movie.getGenre());
        
        return xmlMovieDto;
    }
}
