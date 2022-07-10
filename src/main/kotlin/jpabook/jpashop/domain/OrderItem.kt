package jpabook.jpashop.domain

import jpabook.jpashop.domain.item.Item
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "item_id")
    var item: Item? = null

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order? = null

    var orderPrice: Int? = null // 주문 가격

    var count: Int? = null  // 주문 수량
}
