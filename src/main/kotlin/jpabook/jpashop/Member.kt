package jpabook.jpashop

import javax.persistence.*

@Entity
class Member (
    @Id 
    @Column(name = "id", nullable=false)
    @GeneratedValue
    var id: Long? = null,
    var username: String? = null
)