package com.informatorio2022.ibrnewsapp.persistence.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "source")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Source extends Base {

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "code")
    @NotNull
    private String code;

    @Column(name = "createdAt")
    private LocalDate createdAt;

}
