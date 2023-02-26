package dev.louisa.springbatchdemo.config;

import dev.louisa.springbatchdemo.model.MovieDto;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import static dev.louisa.springbatchdemo.util.ItemReaderUtil.createLineMapper;

@Configuration
public class SpringBootBatchReaderConfig {
    @Value("${file.input}")
    private Resource inputCsv;

    @Bean
    public ItemReader<MovieDto> itemReader() throws UnexpectedInputException, ParseException {
        FlatFileItemReader<MovieDto> reader = new FlatFileItemReader<>();
        reader.setResource(inputCsv);
        reader.setLineMapper(createLineMapper("title", "director", "genre", "remark"));
        return reader;
    }

}
