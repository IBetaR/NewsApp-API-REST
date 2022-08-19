package com.informatorio2022.ibrnewsapp.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "source")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Source extends Base {

    @NotBlank(message = "La fuente debe tener un nombre")
    @Column(name = "name")
    private String name;

//    @Pattern(regexp = "[a-z]", message = "Deben ser minúsculas")
    @NotBlank(message = "La fuente debe tener código identificador")
    @Column(name = "code")
    private String code;

    @PastOrPresent
    @Column(name = "createdAt")
    private LocalDate createdAt;

}
