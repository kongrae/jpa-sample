package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            INSERT CASE
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

//            UPDATE CASE (SET만 해주어도 COMMIT 직전에 업데이트문을 날린다)
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            JPQL CASE22
            List<Member> result = em.createQuery("SELECT m from Member as m", Member.class)
                    .getResultList();
            for (Member member : result){
                System.out.println("member = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
