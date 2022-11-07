package MVC.Dao_op;

import MVC.Model.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class formateurDao {
//    add class
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
            e.printStackTrace();
        }
    }

//    add brief to class
    public void addbrief(Brief brief) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(brief);
            session.persist(brief);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // get formateur
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
            e.printStackTrace();
        }
        return formateur;
    }

    //apprenanate
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
            e.printStackTrace();
        }
        return promotion;
    }

//    get all ma apprenante

    public static List<Classroom> getall_ma_apprenanate(Promotion promotionByIdPromo, Formateur formateurByIdFormateur,String nomClassroom) {
        List< Classroom> listOfclass = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            listOfclass = session.createQuery("select U from Classroom U where U.promotionByIdPromo=:promotionByIdPromo and U.formateurByIdFormateur=:formateurByIdFormateur and U.nomClassroom=:nomClassroom" ).setParameter("promotionByIdPromo",promotionByIdPromo).setParameter("formateurByIdFormateur",formateurByIdFormateur).setParameter("nomClassroom",nomClassroom).getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listOfclass;
    }


    public static List<Classroom> getAllclass() {
        List< Classroom > listOfUser_apprenanate = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            listOfUser_apprenanate = session.createQuery("from Classroom ").getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listOfUser_apprenanate;
    }






//    get one id  class of this formater and promotion

    public static int getid_ma_class(Promotion promotionByIdPromo, Formateur formateurByIdFormateur) {
        int id =0;
        Classroom id_classroom = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            id_classroom = (Classroom) session.createQuery("select U.nomClassroom , U.idClassroom from Classroom U where U.promotionByIdPromo=:promotionByIdPromo and U.formateurByIdFormateur=:formateurByIdFormateur").setParameter("promotionByIdPromo",promotionByIdPromo).setParameter("formateurByIdFormateur",formateurByIdFormateur).getSingleResult();
            id = id_classroom.getIdClassroom();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return id;
    }

    //    get one  class of this formater and promotion
    public  List<Classroom> get_ma_class(Promotion promotionByIdPromo, Formateur formateurByIdFormateur) {
        List<Classroom> classroom = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            classroom =  session.createQuery("select U from Classroom U where U.promotionByIdPromo=:promotionByIdPromo and U.formateurByIdFormateur=:formateurByIdFormateur").setParameter("promotionByIdPromo",promotionByIdPromo).setParameter("formateurByIdFormateur",formateurByIdFormateur).list();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return classroom;
    }

}
