package jpabook.jpashop.repository

import jpabook.jpashop.domain.item.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class ItemRepository {

    @Autowired lateinit var em: EntityManager

    fun save(item: Item): Long {
        if (item.id == 0L){
            em.persist(item)
            println("[DEBUG] new item persist")
        } else {
            em.merge(item)
            println("[DEBUG] duplicated item merge")
        }
        return item.id
    }

    fun findOne(id: Long): Item? {
        return em.find(Item::class.java, id)
    }

    fun findAll(): MutableList<Item> {
        return em.createQuery("select i from Item i", Item::class.java).resultList
    }

}