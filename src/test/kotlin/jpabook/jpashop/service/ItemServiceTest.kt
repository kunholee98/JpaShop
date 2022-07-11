package jpabook.jpashop.service

import jpabook.jpashop.domain.item.Item
import jpabook.jpashop.repository.ItemRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired lateinit var itemService: ItemService
    @Autowired lateinit var itemRepository: ItemRepository

    // create item
    @Test
    fun saveItem() {
        val newItem = Item().apply {
            this.name = "item"
        }
        val newItemId = itemService.saveItem(newItem)

        Assertions.assertEquals(newItem.id, newItemId)
    }

    // save item twice
    @Test
    fun duplicateItemTest() {
        val newItem = Item().apply {
            this.name = "item"
        }
        val newItemId = itemService.saveItem(newItem)
        val newItemId2 = itemService.findOne(newItemId)?.let { itemService.saveItem(it) }
    }

    // find one item
    @Test
    fun findOneTest() {
        val newItem = Item().apply {
            this.name = "item"
        }
        val newItemId = itemService.saveItem(newItem)
        val result = itemService.findOne(newItemId)

        Assertions.assertEquals(newItemId, result?.id)
        Assertions.assertEquals("item", result?.name)
    }

    // find non-existed item
    @Test
    fun findNonExistedItemTest() {
        val size = (itemService.findAll().size + 1).toLong()
        val result = itemService.findOne(size)

        Assertions.assertNull(result)

    }

    // find all items
    @Test
    fun findAllItemTest() {
        val newItem1 = Item().apply {this.name = "item1"}
        val newItem2 = Item().apply {this.name = "item2"}
        val newItem3 = Item().apply {this.name = "item3"}
        itemService.saveItem(newItem1)
        itemService.saveItem(newItem2)
        itemService.saveItem(newItem3)
        val list = itemService.findAll()

        Assertions.assertEquals(3, list.size)

    }
}