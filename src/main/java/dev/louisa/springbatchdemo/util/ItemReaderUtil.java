package dev.louisa.springbatchdemo.util;

import dev.louisa.springbatchdemo.model.MovieDto;
import dev.louisa.springbatchdemo.service.RecordFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class ItemReaderUtil {

    private static final String DELIMITER = ";";

    private ItemReaderUtil(){
        // This is a util class. This class should never be instantiated.    
    }

    public static DefaultLineMapper<MovieDto> createLineMapper(String ... tokens) {
        DefaultLineMapper<MovieDto> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(createTokenizer(tokens));
        lineMapper.setFieldSetMapper(new RecordFieldSetMapper());

        return lineMapper;
    }

    private static LineTokenizer createTokenizer(String ... tokens) {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(tokens);
        tokenizer.setDelimiter(DELIMITER);

        return tokenizer;
    }

}
