package dev.louisa.springbatchdemo.config;

import dev.louisa.springbatchdemo.dto.outbound.JsonMovieDto;
import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import dev.louisa.springbatchdemo.model.Movie;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableBatchProcessing
public class SpringBootBatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    public SpringBootBatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean(name = "firstBatchJob")
    public Job job(Step step) {
        return jobBuilderFactory
                .get("firstBatchJob")
                .start(step)
                .build();
    }

    @Bean
    @Profile({"default", "to-xml"})
    protected Step stepXml(ItemReader<Movie> reader,
                         ItemProcessor<Movie, XmlMovieDto> processor,
                         ItemWriter<XmlMovieDto> writer) {
        return stepBuilderFactory
                .get("step")
                .<Movie, XmlMovieDto>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    @Profile({"to-json"})
    protected Step stepJson(ItemReader<Movie> reader,
                            ItemProcessor<Movie, JsonMovieDto> processor,
                            ItemWriter<JsonMovieDto> writer) {
        return stepBuilderFactory
                .get("step")
                .<Movie, JsonMovieDto>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}