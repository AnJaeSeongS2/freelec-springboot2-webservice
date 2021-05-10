package org.sonan.book.springboot.domain.post;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest extends TestCase {

    @Autowired
    PostRepository postRepo;

    @After
    public void cleanup() {
        System.out.println("start cleanup");
        postRepo.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "jindam91@gmail.com";

        System.out.println("save");
        postRepo.save(Post.builder()
            .title(title)
            .content(content)
            .author(author)
            .build());

        //when
        System.out.println("finaAll");
        List<Post> postList = postRepo.findAll();
        System.out.println("finaAll after");

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getAuthor()).isEqualTo(author);
    }

    @Test
    public void BaseTimeEntity_등록() throws Exception {
        //given
        LocalDateTime prevSaveTime = LocalDateTime.now();
        System.out.println(">>>>>>>  prevSaveTime=" + prevSaveTime);
        postRepo.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Post> all = postRepo.findAll();

        //then
        Post post = all.get(0);
        Thread.sleep(2000);
        post.update("title2", "content2");


        // create, update가 한번에 commit되므로 값이 같다.
        System.out.println(">>>>>>>  createdDate=" + post.getCreatedDate() + ", modifiedDate=" + post.getModifiedDate());
        assertThat(post.getCreatedDate()).isAfterOrEqualTo(prevSaveTime);
        assertThat(post.getModifiedDate()).isAfterOrEqualTo(prevSaveTime);
    }
}