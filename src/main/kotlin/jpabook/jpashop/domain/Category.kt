package jpabook.jpashop.domain

import jpabook.jpashop.domain.item.Item
import javax.persistence.*

@Entity
class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    var id: Long? = null

    var name: String? = null

    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")]
        )  // ORM 에서 ManyToMany 를 풀어낼 수 있는 중간 테이블이 필요. 하지만 이는 필드를 추가할 수 없기 때문에 보통 실무에서 사용하지 않음.
    var items: MutableList<Item> = mutableListOf()


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    var parent: Category? = null

    @OneToMany(mappedBy = "parent")
    var children: MutableList<Category>? = mutableListOf()
}