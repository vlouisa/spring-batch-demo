package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.dto.mapper.DtoMapper;
import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomItemProcessor implements ItemProcessor<Movie, XmlMovieDto> {

    @Override
    public XmlMovieDto process(Movie movie) {
        log.info("Processing record: " + movie);
        return DtoMapper.mapToXml(movie);
    }
}
