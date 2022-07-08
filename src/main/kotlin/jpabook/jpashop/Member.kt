package jpabook.jpashop

import javax.persistence.*

@Entity
class Member {
    @Id
    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var username: String? = null

}