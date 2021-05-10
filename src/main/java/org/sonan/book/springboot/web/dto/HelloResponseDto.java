package org.sonan.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
