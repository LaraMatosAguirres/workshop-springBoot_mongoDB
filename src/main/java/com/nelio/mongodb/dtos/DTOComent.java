package com.nelio.mongodb.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DTOComent implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private Date date;
    private String body;
    private DTOAuthor author;

    public DTOComent(){
    }

    public DTOComent( String body, Date date, DTOAuthor author) {
        this.date = date;
        this.body = body;
        this.author = author;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public DTOAuthor getAuthor() {
        return author;
    }

    public void setAuthor(DTOAuthor author) {
        this.author = author;
    }

}
