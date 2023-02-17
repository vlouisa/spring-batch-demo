package dev.louisa.springbatchdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Movie {
    private String title;
    private String director;
    private String genre;
    private String remark;
}
