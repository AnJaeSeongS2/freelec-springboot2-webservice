package org.sonan.book.springboot.service.post;

import lombok.RequiredArgsConstructor;
import org.sonan.book.springboot.domain.post.Post;
import org.sonan.book.springboot.domain.post.PostRepository;
import org.sonan.book.springboot.web.dto.PostCreateRequestDto;
import org.sonan.book.springboot.web.dto.PostResponseDto;
import org.sonan.book.springboot.web.dto.PostUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * update 시, repo에 직접 쿼리날리는 부분이 없는 이유는 JPA의 영속성 컨텍스트 때문임. Post 엔티티가 영속성 컨텍스트에 포함되어있다.
 * Transaction 안에 DB에서 data를 가져오면 데이터는 영속성 컨텍스트가 유지된 상태임. 데이터 값을 변경하면 트랜잭션이 끝나는 시점에 db update, commit이 이루어진다.
 * 별도로 update 쿼리를 날릴 필요가 없다. 이러한 부분은 dirty checking 이라한다. 영속성 컨텍스트인 엔티티에 dirty 여부가 있는 지 확인한다.
 *
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepo;

    @Transactional
    public Long create(PostCreateRequestDto reqDto) {
        return postRepo.save(reqDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto reqDto) {
        Post post = postRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.update(reqDto.getTitle(), reqDto.getContent());
        return post.getId();
    }

    public PostResponseDto get(Long id)  {
        Post entity = postRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostResponseDto(entity);
    }
}
