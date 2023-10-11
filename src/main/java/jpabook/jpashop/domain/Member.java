package jpabook.jpashop.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter // lombok 사용
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // mappedBy : 읽기만 가능(주인이 아니라서)
    private List<Order> orders = new ArrayList<>();
}
