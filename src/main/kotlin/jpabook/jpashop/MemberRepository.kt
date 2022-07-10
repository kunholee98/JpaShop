package jpabook.jpashop

import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface MemberRepository: JpaRepository<Member, String> {

//    @get:PersistenceContext
//    val em: EntityManagerFactory

}