package dev.louisa.springbatchdemo.config;

import dev.louisa.springbatchdemo.dto.outbound.XmlMovieDto;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SpringbootBatchWriterConfig {
    @Value("${file.output.xml}")
    private Resource outputXml;

    @Bean
    @Profile({"to-xml"})
    public ItemWriter<XmlMovieDto> itemWriter(Marshaller marshaller) {
        StaxEventItemWriter<XmlMovieDto> itemWriter = new StaxEventItemWriter<>();
        itemWriter.setMarshaller(marshaller);
        itemWriter.setRootTagName("Movies");
        itemWriter.setResource(outputXml);
        return itemWriter;
    }

    @Bean
    @Profile({"to-xml"})
    public Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(XmlMovieDto.class);
        return marshaller;
    }
}
