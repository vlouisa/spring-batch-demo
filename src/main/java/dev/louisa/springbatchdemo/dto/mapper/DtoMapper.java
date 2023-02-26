package dev.louisa.springbatchdemo.dto.mapper;

import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.dto.inbound.MovieDto;

public class DtoMapper {
    public static XmlMovieDto mapToXml(MovieDto movieDto) {
        XmlMovieDto xmlMovieDto = new XmlMovieDto();
        xmlMovieDto.setRemark(movieDto.getRemark());
        xmlMovieDto.setDirector(movieDto.getDirector());
        xmlMovieDto.setTitle(movieDto.getTitle());
        xmlMovieDto.setGenre(movieDto.getGenre());

        return xmlMovieDto;
    }
}
