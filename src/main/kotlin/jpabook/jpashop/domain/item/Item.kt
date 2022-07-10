package jpabook.jpashop.domain.item

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    var id: Long? = null

    var name: String? = null

    var price: Int? = null

    var stockQuantity: Int? = null



}
