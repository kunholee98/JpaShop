package jpabook.jpashop

import jpabook.jpashop.domain.Member
import jpabook.jpashop.repository.MemberRepository
import jpabook.jpashop.service.MemberService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional


@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired lateinit var memberService: MemberService
    @Autowired lateinit var memberRepository: MemberRepository

    @Test   // 회원가입
//    @Rollback(false)
    fun memberJoinTest() {
        val newMember = Member().apply {
            this.username = "tino"
        }

        val memberId = memberService.join(newMember)
        println("member: " + memberService.findMemberById(memberId))
        Assertions.assertEquals(newMember, memberService.findMemberById(memberId))
    }

    @Test
    fun duplicatedJoinTest() {

        val duplicatedMember = Member().apply {
            this.username = "tino"
        }
        val newMember = Member().apply {
            this.username = "tino"
        }

        memberService.join(newMember)
        try {
            memberService.join(duplicatedMember)
        } catch (e: IllegalStateException) {
            return
        }

        fail("Illegal Exception 발생 필요")

    }


}