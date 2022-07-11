package jpabook.jpashop

import jpabook.jpashop.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: JpaRepository<Member, Long> {

//    @get:PersistenceContext
//    val em: EntityManagerFactory

}