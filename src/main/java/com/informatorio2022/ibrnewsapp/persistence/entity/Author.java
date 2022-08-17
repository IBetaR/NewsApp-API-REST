package com.informatorio2022.ibrnewsapp.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "author")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Author extends Base{

    @NotBlank(message = "Nombre no debe estar vacío")
    @Size(min = 3)
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_source")
    private Source source;

}