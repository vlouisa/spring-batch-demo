package dev.louisa.springbatchdemo.dto.mapper;

import dev.louisa.springbatchdemo.dto.outbound.JsonMovieDto;
import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.model.MovieDto;

public class DtoMapper {

    public static XmlMovieDto mapToXml(MovieDto movieDto) {
        XmlMovieDto xmlMovieDto = new XmlMovieDto();
        xmlMovieDto.setRemark(movieDto.getRemark());
        xmlMovieDto.setDirector(movieDto.getDirector());
        xmlMovieDto.setTitle(movieDto.getTitle());
        xmlMovieDto.setGenre(movieDto.getGenre());
        
        return xmlMovieDto;
    }

    public static JsonMovieDto mapToJson(MovieDto movie) {
        JsonMovieDto movieDto = new JsonMovieDto();
        movieDto.setRemark(movie.getRemark());
        movieDto.setDirector(movie.getDirector());
        movieDto.setTitle(movie.getTitle());
        movieDto.setGenre(movie.getGenre());
        
        return movieDto;
    }


}
