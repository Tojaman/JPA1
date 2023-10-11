package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delevery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery") // 주인이 아니니깐 읽기만 가능
    private Order order;

    @Embedded
    private Address address;

    // EnumType.ORDINAL : 데이터베이스 열에 순서값 저장(0, 1, 2, 3 ...)
    // EnumType.STRING : 데이터베이스 열에 미리 설정한? 문자열 저장
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY, COMP(배송중)
}
