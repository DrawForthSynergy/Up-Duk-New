package com.shop.entity;

import com.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Setter @Getter
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    //한 명의 회원은 주문을 여러번 할 수 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    //연관관계의 주인은 orderitem 엔티티이다(왜래키- order_id가 그쪽에 있어서). mappedBy속성으로 연관관계 주인 설정, OrderItem에 있는 order 필드에 의해 관리된다는 의미.
    // 보통 1:N, N:1에서 N이 연관관계 주인이다.
    // 부모 엔티티의 영속성 상태 변화를 자식엔티티에 모두 전이하는 CascaseTypeAll 옵션 설정
    // 고아 객체: 부모 엔티티와 연관관계가 끊어진 자식 엔티티, 고아객체 제거하기 위해 orphanRemoval = true 옵션 추가
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //하나의 주문이 여러개의 주문 상품을 갖는다.
    private List<OrderItem> orderItems = new ArrayList<>();

}
