package MVC.Dao_op;

import MVC.Model.Apprenante;
import MVC.Model.Classroom;
import MVC.Model.Formateur;
import MVC.Model.Promotion;
import org.hibernate.Session;

public class formateurDao {
    public void addclass(Classroom classroom) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(classroom);
            session.persist(classroom);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    //formateur
    public Formateur getformateur(int idFormateur) {
        Formateur formateur= null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            formateur = (Formateur) session.createQuery("select s from Formateur s where s.idFormateur=:idFormateur", Formateur.class).setParameter("idFormateur", idFormateur).uniqueResult();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return formateur;
    }
    //appre
    public Apprenante getapp(int idApprenante) {
        Apprenante apprenante= null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            apprenante = (Apprenante) session.createQuery("select s from Apprenante s where s.idApprenante=:idApprenante", Apprenante.class).setParameter("idApprenante", idApprenante).uniqueResult();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return apprenante;
    }
    //promo

    public Promotion getpromo(int idPromo) {
        Promotion promotion= null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            promotion = (Promotion) session.createQuery("select s from Promotion s where s.idPromo=:idPromo", Promotion.class).setParameter("idPromo", idPromo).uniqueResult();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return promotion;
    }
    //get id formateur

}
