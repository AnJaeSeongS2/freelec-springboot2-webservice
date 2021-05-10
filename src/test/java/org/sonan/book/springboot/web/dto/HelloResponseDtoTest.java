package org.sonan.book.springboot.web.dto;

import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class HelloResponseDtoTest extends TestCase {

    @Test
    public void testTestGetName_롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}