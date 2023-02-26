package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.dto.mapper.DtoMapper;
import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.model.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"default", "to-xml"})
public class CustomXmlItemProcessor implements ItemProcessor<MovieDto, XmlMovieDto> {

    @Override
    public XmlMovieDto process(MovieDto movieDto) {
        log.info("Processing record: " + movieDto);
        return DtoMapper.mapToXml(movieDto);
    }
}
