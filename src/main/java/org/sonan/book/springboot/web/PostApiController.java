package org.sonan.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.sonan.book.springboot.service.post.PostService;
import org.sonan.book.springboot.web.dto.PostCreateRequestDto;
import org.sonan.book.springboot.web.dto.PostResponseDto;
import org.sonan.book.springboot.web.dto.PostUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostApiController {

    // @Autowired lombok @RequiredArgsContructor 에 의해 자동으로 bean주입이 끝난다.
    // 생성자에서 알아서 주입되고 있기 때문에, field변경이 일어나도 코드 변경이 적다.
    private final PostService postServ;

    @PostMapping
    public Long create(@RequestBody PostCreateRequestDto reqDto) {
        return postServ.create(reqDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto reqDto) {
        return postServ.update(id, reqDto);
    }

    @GetMapping("/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postServ.get(id);
    }

}
