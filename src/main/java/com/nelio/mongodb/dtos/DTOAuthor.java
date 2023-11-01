package com.nelio.mongodb.dtos;

import com.nelio.mongodb.domains.User;

import java.io.Serializable;
import java.util.Objects;

public class DTOAuthor implements Serializable {
    private static final long serialVerisonnUID = 1L;

    private String id;
    private String name;

    public DTOAuthor(){
    }

    public DTOAuthor(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTOAuthor dtoAuthor = (DTOAuthor) o;
        return Objects.equals(id, dtoAuthor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
