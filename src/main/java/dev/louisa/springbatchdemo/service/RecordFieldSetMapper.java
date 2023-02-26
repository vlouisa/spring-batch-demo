package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.model.MovieDto;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class RecordFieldSetMapper implements FieldSetMapper<MovieDto> {

    @Override
    public MovieDto mapFieldSet(FieldSet fieldSet) {
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle(fieldSet.readString(0));
        movieDto.setDirector(fieldSet.readString(1));
        movieDto.setGenre(fieldSet.readString(2));
        movieDto.setRemark(fieldSet.readString(3));
        
        return movieDto;
    }
}
