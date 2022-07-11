package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Category
import jpabook.jpashop.exception.NotEnoughStockException
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    var id: Long = 0L

    var name: String = ""

    var price: Int = 0

    var stockQuantity: Int = 0

    @ManyToMany(mappedBy = "items")
    var categories: MutableList<Category> = mutableListOf()

    // 전체 수량 추가
    fun addStock (quantity: Int) {
        this.stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        val remain = this.stockQuantity - quantity
        if (remain < 0) {
            throw NotEnoughStockException("재고가 부족합니다.")
        }
        this.stockQuantity = remain
    }




}
