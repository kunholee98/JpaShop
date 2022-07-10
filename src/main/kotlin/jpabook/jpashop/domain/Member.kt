package jpabook.jpashop.domain

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member (
    @Id @GeneratedValue
    @Column(name = "member_id")
    var id: Long? = null,

    var username: String? = null,

    @Embedded
    var address: Address? = null,

    @OneToMany(mappedBy = "member") // order 의 member 변경에 따라 mapped 된다.
    var orders: MutableList<Order> = mutableListOf()
)
