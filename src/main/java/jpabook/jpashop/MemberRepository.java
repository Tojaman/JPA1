package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository // @Component 포함되어 있음
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; // EntitiManager을 스프링 부트에서 만들어줌(스타터 라이브러리)

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
