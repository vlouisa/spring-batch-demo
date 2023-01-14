package dev.louisa.springbatchdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class Movie {
    
    @XmlElement(name="Title")
    private String title;

    @XmlElement(name="Director")
    private String director;

    @XmlElement(name="Genre")
    private String genre;

    @XmlElement(name="Remark")
    private String remark;
}
