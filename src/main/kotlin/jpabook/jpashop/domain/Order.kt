package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "orders")
class Order(

    @Id @GeneratedValue
    @Column(name = "order_id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member,

    @OneToMany(mappedBy = "item", cascade = [CascadeType.ALL])  // persist 전파
    var orderItems: MutableList<OrderItem> = mutableListOf(),

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery? = null,

    var orderDate: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus? = null,       // 주문 상태: [ORDER, CANCEL]

)