package com.shop.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//Auditing을 추가하기 위해
//@EntityListeners 는 엔티티를 DB에 적용하기 전, 이후에 커스텀 콜백을 요청할 수 있는 어노테이션이다.
//@EntityListeners 의 인자로 커스텀 콜백을 요청할 클래스를 지정해주면 되는데, Auditing 을 수행할 때는 JPA 에서 제공하는 AuditingEntityListener.class 를 인자로 넘기면 된다.
@EntityListeners(value = {AuditingEntityListener.class})
// 공통 매핑 정보가 필요할 때 사용, 부모 클래스(엔티티)에 필드를 선언하고 단순히 속성만 받아서 사용하고싶을 때
@MappedSuperclass
@Getter @Setter
public abstract class BaseTimeEntity {

    //엔티티가 생성되어 저장될 때 시간을 자동으로 저장
    @CreatedDate
    //해당 BaseEntity를 JPA가 테이블에 접근하는 시점에만 JPA가 사용하도록 하고 싶은데 만약 개발자에 의해 수정되면 안되기 때문에 updatable을 false로 해주는 것을 권장한다.
    @Column(updatable = false)
    private LocalDateTime regTime;  //등록일

    //엔티티의 값을 변경할 때 시간을 자동으로 저장
    @LastModifiedDate
    private LocalDateTime updateTime;  //수정일
}
