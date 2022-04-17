package hellojpa

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main(args: Array<String>){
    val emf = Persistence . createEntityManagerFactory ("hello");

    val em = emf.createEntityManager();

    val tx = em.transaction;
    tx.begin();

    try{
        val member = Member();
        member.id = 1L;
        member.name = "helloJpa";
        member.roleType = RoleType.USER;
        em.persist(member);

        tx.commit();
    }catch (e : java.lang.Exception){
        tx.rollback();
    }finally{
        em.close();
    }
    emf.close();
}