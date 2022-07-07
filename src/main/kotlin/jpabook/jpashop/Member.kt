package jpabook.jpashop

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member (
    @Id @GeneratedValue
    var id: Int? = null,
    var username: String? = null
)