package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "orders")
class Order(

    @Id @GeneratedValue
    @Column(name = "order_id")
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "member_id")
    var member: Member,

    @OneToMany(mappedBy = "order_id")
    var orderItems: MutableList<OrderItem> = mutableListOf(),

    @OneToOne
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery? = null,

    var orderDate: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus? = null,       // 주문 상태: [ORDER, CANCEL]


)