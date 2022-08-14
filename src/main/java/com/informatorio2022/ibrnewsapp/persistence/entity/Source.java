package com.informatorio2022.ibrnewsapp.persistence.entity;

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
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "createdAt")
    private LocalDate createdAt;

}
