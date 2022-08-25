package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository<엔티티 타입 클래스, 기본키 타입> id의 기본키 타입이 Long임
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    //파라미터로 들어온 값을 JPQL에 들어갈 변수로 지
    List<Item> findByItemDetail(@Param("itemDetail") String ItemDetail);
}
