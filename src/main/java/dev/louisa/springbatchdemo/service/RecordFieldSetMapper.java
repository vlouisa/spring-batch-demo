package dev.louisa.springbatchdemo.service;

import dev.louisa.springbatchdemo.model.Movie;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class RecordFieldSetMapper implements FieldSetMapper<Movie> {

    @Override
    public Movie mapFieldSet(FieldSet fieldSet) {
        Movie movie = new Movie();
        movie.setTitle(fieldSet.readString(0));
        movie.setDirector(fieldSet.readString(1));
        movie.setGenre(fieldSet.readString(2));
        movie.setRemark(fieldSet.readString(3));
        
        return movie;
    }
}
