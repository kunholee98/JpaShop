package jpabook.jpashop

import jpabook.jpashop.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, String> {

//    @get:PersistenceContext
//    val em: EntityManagerFactory

}