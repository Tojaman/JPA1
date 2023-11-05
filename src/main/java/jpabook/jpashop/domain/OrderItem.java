package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    // XToOne = 기본이 즉시로딩(EAGER)이므로 LAZY로 변경해줘야 한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    // // XToOne = 기본이 즉시로딩(EAGER)이므로 LAZY로 변경해줘야 한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 가격
    private int count; // 주문 수량

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count); // 주문 수량만큼 재고에서 빼기
        return orderItem;
    }

    //==비즈니스 로직==//
//    주문 취소시 재고 수량 원복
    public void cancel() {
        getItem().addStock(count);
    }

    //==조회 로직==//


    /**
     * 주문 상품 전체 가격 조회
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
