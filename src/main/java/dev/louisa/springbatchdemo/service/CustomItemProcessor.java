package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.dto.mapper.DtoMapper;
import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.dto.inbound.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomItemProcessor implements ItemProcessor<MovieDto, XmlMovieDto> {

    @Override
    public XmlMovieDto process(MovieDto movieDto) {
        log.info("Processing record: " + movieDto);
        return DtoMapper.mapToXml(movieDto);
    }
}
