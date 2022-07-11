package jpabook.jpashop.repository

import jpabook.jpashop.domain.Member
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class MemberRepository {

    @PersistenceContext
    lateinit var em: EntityManager

    fun save(member: Member) {
        em.persist(member)
    }

    fun findOne(id: Long): Member? {
        return em.find(Member::class.java, id)
    }

    fun findAll(): MutableList<Member>? {
        // table 이 아닌 entity object 에 대해서 쿼리를 날림. JPQL (SQL 과 유사)
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }

    fun findByName(name: String): MutableList<Member>? {
        return em.createQuery("select m from Member m where m.username = :name", Member::class.java)
            .setParameter("name", name)
            .resultList
    }
}