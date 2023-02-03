package dev.louisa.springbatchdemo.dto.outbound;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JsonMovieDto {
    
    private String title;
    private String director;
    private String genre;
    private String remark;
}
