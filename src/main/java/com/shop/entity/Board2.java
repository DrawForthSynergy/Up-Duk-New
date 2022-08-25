package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
// item 테이블과 매핑
@Table(name="board2")
@Getter
@Setter
@ToString
@Data
public class Board2 {

    @Id
    //기본키
    @Column(name="board2_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;       //상품 코드

    @Column(nullable = false, length = 50)
    private String title; //상품명

    @Lob
    @Column(nullable = false)
    private String content; //상품 상세 설명




}