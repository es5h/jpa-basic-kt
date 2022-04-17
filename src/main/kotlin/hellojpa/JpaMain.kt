package hellojpa

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main(args: Array<String>){
    var emf = Persistence . createEntityManagerFactory ("hello");

    var em = emf.createEntityManager();

    var tx = em.transaction;
    tx.begin();

    try{
        var result = em.createQuery("select m from Member as m", Member::class.java).resultList;

        for(member in result){
            println("member.name" + member.name);
        }

        tx.commit();
    }catch (e : java.lang.Exception){
        tx.rollback();
    }finally{
        em.close();
    }
    emf.close();
}