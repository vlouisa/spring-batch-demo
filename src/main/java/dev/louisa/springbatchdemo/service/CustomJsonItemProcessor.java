package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.dto.mapper.DtoMapper;
import dev.louisa.springbatchdemo.dto.outbound.JsonMovieDto;
import dev.louisa.springbatchdemo.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("to-json")
public class CustomJsonItemProcessor implements ItemProcessor<Movie, JsonMovieDto> {

    @Override
    public JsonMovieDto process(Movie movie) {
        log.info("Processing record: " + movie);
        return DtoMapper.mapToJson(movie);
    }
}
