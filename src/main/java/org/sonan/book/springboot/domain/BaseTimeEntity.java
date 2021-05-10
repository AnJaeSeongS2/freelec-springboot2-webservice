package org.sonan.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * entity의 createdDate, modifiedDate를 자동 관리
 *
 * SpringBootApplication에 @EnableJpaAuditing를 추가해 활성화 필요함.
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@Getter
@MappedSuperclass // jpa entity클래스가 이 클래스를 상속할 경우, 이 클래스의 필드들도 칼럼으로 인식한다.
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity에 auditing기능 포함시킴.
public abstract class BaseTimeEntity {

    @CreatedDate // 엔티티 생성시 자동저장되는 시간.
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티 변경시 자동저장되는 시간.
    private LocalDateTime modifiedDate;
}
