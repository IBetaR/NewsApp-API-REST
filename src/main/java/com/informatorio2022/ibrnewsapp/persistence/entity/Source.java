package com.informatorio2022.ibrnewsapp.persistence.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @NotBlank(message = "La fuente debe tener código identificador")
    @Column(name = "code")
    private String code;

    @Column(name = "createdAt")
    private LocalDate createdAt;

}
