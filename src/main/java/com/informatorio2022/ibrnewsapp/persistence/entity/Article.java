package com.informatorio2022.ibrnewsapp.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "article")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Article extends Base{

    @NotBlank(message = "Debe tener un título")
    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 1500)
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "urlToImage")
    private String urlToImage;

    @PastOrPresent
    @Column(name = "publishedAt")
    private LocalDate publishedAt;

    @Column(name = "content", length = 1500)
    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_author")
    private Author author;

    @Column(name = "article_status")
    private ArticleStatus articleStatus;


}