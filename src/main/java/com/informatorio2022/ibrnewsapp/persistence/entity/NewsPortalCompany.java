package com.informatorio2022.ibrnewsapp.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class NewsPortalCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cuit;

    public NewsPortalCompany() {
    }

    public NewsPortalCompany(Long id, String name, String cuit) {
        this.id = id;
        this.name = name;
        this.cuit = cuit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsPortalCompany that = (NewsPortalCompany) o;
        return id.equals(that.id) && name.equals(that.name) && cuit.equals(that.cuit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cuit);
    }

    @Override
    public String toString() {
        return "NewsPortalCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuit='" + cuit + '\'' +
                '}';
    }
}
