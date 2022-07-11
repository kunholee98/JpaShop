package jpabook.jpashop.service

import jpabook.jpashop.domain.Member
import jpabook.jpashop.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional(readOnly = true)  // lazy loading 가능, fun 마다 직접 설정 가능, readOnly = true 를 통해 read 최적화
class MemberService(
    @Autowired
    var memberRepository: MemberRepository
) {

    // 회원가입
    @Transactional  // DB 를 변경하는 부분은 annotation 을 다시 적어주어 쓰기도 가능하게끔
    fun join(member: Member): Long {
        validateDuplicateMember(member) // 중복회원 검증
        memberRepository.save(member)
        // em.persist 를 통해 객체를 새로 주입하게 되면 key-value 형태로 저장이 되고, 이때 key 는 pk 가 된다.
        // 따라서 member.id 와 같은 형태를 사용할 수 있다.
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        // multi thread 상황에서 validation 이 제대로 안먹힐 수 있기 때문에 DB 에 unique 조건도 걸어두는 것 필요
        val memberList = memberRepository.findByName(member.username)
        if (memberList.isNotEmpty()) throw IllegalStateException("이미 존재하는 회원입니다.")
    }

    // 회원 전체 조회
    fun findMembers(): MutableList<Member> {
        return memberRepository.findAll()
    }


    // 회원 1명 조회
    fun findMemberById(id: Long): Member? {
        return memberRepository.findOne(id)
    }
}