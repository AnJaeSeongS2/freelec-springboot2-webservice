package org.sonan.book.springboot.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * db table과 연결된 패러다임의 연결을 도맡은 클래스이므로 Entity역할을 하는 클래스는 view <-> controller에서 겸용으로 사용하는 것은 위험이 도래한다.
 * controller <-> view 에서 PostSaveRequestDto 로 별로 POJO가 존재한다.
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@Getter
@NoArgsConstructor
@DynamicUpdate
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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
