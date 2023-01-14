package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomItemProcessor implements ItemProcessor<Movie, Movie> {

    @Override
    public Movie process(Movie movie) {
        log.info("Processing record: " + movie);
        return movie;
    }
}
