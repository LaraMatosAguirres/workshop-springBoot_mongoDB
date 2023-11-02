package com.nelio.mongodb.domains;

import com.nelio.mongodb.dtos.DTOAuthor;
import com.nelio.mongodb.dtos.DTOComent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "post")
public class Post implements Serializable {
    private static final long serialVerisonnUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private DTOAuthor author;

    private List<DTOComent> coments = new ArrayList<>();

    public Post(){
    }

    public Post(String id, Date date, String title, String body, DTOAuthor author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<DTOComent> getComents() {
        return coments;
    }

    public void setComents(List<DTOComent> coments) {
        this.coments = coments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
