package jpabook.jpashop

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.PersistenceContext

interface MemberRepository: JpaRepository<Member, String> {

//    @get:PersistenceContext
//    val em: EntityManagerFactory

}