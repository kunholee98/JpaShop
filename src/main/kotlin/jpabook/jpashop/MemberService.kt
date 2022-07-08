package jpabook.jpashop

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
class MemberService(
    var memberRepository: MemberRepository
) {

    @PersistenceContext
    private lateinit var em: EntityManager

    fun addMember(member: Member): Member {
        em.persist(member)
        return memberRepository.save(member)
    }

    fun findMember(id: Long): Member? {
        return memberRepository.findByIdOrNull(id)
    }
}