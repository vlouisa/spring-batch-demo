package dev.louisa.springbatchdemo.config;

import dev.louisa.springbatchdemo.model.Movie;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import static dev.louisa.springbatchdemo.util.ItemReaderUtil.createLineMapper;

@Configuration
@EnableBatchProcessing
public class SpringBootBatchConfig {
    @Value("${file.input}")
    private Resource inputCsv;
    
    @Value("${file.output}")
    private Resource outputXml;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    public SpringBootBatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }
    
    @Bean
    public ItemReader<Movie> itemReader() throws UnexpectedInputException, ParseException {
        FlatFileItemReader<Movie> reader = new FlatFileItemReader<>();
        reader.setResource(inputCsv);
        reader.setLineMapper(createLineMapper("title", "director", "genre", "remark"));
        return reader;
    }
    
    @Bean
    public ItemWriter<Movie> itemWriter(Marshaller marshaller) {
        StaxEventItemWriter<Movie> itemWriter = new StaxEventItemWriter<>();
        itemWriter.setMarshaller(marshaller);
        itemWriter.setRootTagName("Movies");
        itemWriter.setResource(outputXml);
        return itemWriter;
    }

    @Bean
    public Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Movie.class);
        return marshaller;
    }

    @Bean
    protected Step step1(ItemReader<Movie> reader,
                         ItemProcessor<Movie, Movie> processor,
                         ItemWriter<Movie> writer) {
        return stepBuilderFactory
                .get("step1")
                .<Movie, Movie> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean(name = "firstBatchJob")
    public Job job(@Qualifier("step1") Step step) {
        return jobBuilderFactory
                .get("firstBatchJob")
                .start(step)
                .build();
    }
}