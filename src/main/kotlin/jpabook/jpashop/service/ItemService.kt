package jpabook.jpashop.service

import jpabook.jpashop.domain.item.Item
import jpabook.jpashop.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ItemService(
    @Autowired var itemRepository: ItemRepository
) {

    @Transactional
    fun saveItem(item: Item): Long {
        return itemRepository.save(item)
    }

    fun findAll(): MutableList<Item> {
        return itemRepository.findAll()
    }

    fun findOne(id: Long): Item? {
        return itemRepository.findOne(id)
    }
}