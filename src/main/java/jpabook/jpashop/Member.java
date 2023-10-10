package jpabook.jpashop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter // lombok 사용
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
}
