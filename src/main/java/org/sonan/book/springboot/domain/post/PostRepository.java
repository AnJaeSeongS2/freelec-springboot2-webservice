package org.sonan.book.springboot.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
