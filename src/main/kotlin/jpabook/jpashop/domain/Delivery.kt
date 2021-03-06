package jpabook.jpashop.domain

import javax.persistence.*

@Entity
class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery")
    var order: Order? = null

    @Embedded
    var address: Address? = null

    @Enumerated(EnumType.STRING)
    var delivery: DeliveryStatus? = null

}
