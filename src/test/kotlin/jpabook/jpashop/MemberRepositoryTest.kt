package jpabook.jpashop

import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.web.WebAppConfiguration
import javax.persistence.EntityManager

@WebAppConfiguration
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository
    @Autowired
    lateinit var entityManager: EntityManager

    @Before
    fun setUp() {
        entityManager.clear()
    }

    @Test
    fun saveTest(e: Exception) {
        val newMember = Member().apply {
            this.username = "tino"
        }

        val result = memberRepository.save(newMember)

        Assertions.assertEquals("tino", result.username)
    }
}