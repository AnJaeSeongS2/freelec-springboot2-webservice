package org.sonan.book.springboot.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
