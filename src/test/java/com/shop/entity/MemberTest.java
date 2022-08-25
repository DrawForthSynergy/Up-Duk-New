package com.shop.entity;

import com.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@SpringBootTest
//트랜잭션 처리 지원, 메서드가 종료될 때 자동으로 롤백된다.
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
public class MemberTest {
    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("Auditing 테스트")
    //지정한 사용자가 로그인한 상태라고 가정하고 테스트한다.
    @WithMockUser(username = "gildong", roles = "USER")
    public void auditingTest(){
        Member newMember = new Member();
        memberRepository.save(newMember);

        //데이터베이스에 저장하고, 영속성 컨텍스트를 지운다. -> 그리고 find를 하면 영속성컨텍스트에 데이터가 없으니까 데이터베이스에서 조회하게 된다.
        em.flush();
        em.clear();

        Member member = memberRepository.findById(newMember.getId())
                .orElseThrow(EntityNotFoundException::new);

        System.out.println("register time: " + member.getRegTime());
        System.out.println("update time: " + member.getUpdateTime());
        System.out.println("create member: " + member.getCreatedBy());
        System.out.println("update member: " + member.getModifiedBy());

    }
}
