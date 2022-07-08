package jpabook.jpashop

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional


@ExtendWith(SpringExtension::class)
@SpringBootTest
class MemberServiceTest {

    @Autowired
    lateinit var memberService: MemberService

    @Test
    @Transactional
    @Rollback(value = false)
    fun addMemberTest(){
        val newMember = Member().apply {
            this.id = 1
            this.username = "tino"
        }

        val result = memberService.addMember(newMember)
        println(result)
        Assertions.assertEquals(1,result.id)
        Assertions.assertEquals("tino",result.username)

    }

}