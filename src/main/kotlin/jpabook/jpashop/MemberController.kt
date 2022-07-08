package jpabook.jpashop

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/member")
class MemberController(
    var memberService: MemberService
) {

    @PostMapping("")
    fun addMember(
        @RequestBody member: Member
    ): Member {
        return memberService.addMember(member)
    }

    @GetMapping("/{userId}")
    fun findMember(@PathVariable userId: Long): Member? {
        return memberService.findMember(userId)
    }

}