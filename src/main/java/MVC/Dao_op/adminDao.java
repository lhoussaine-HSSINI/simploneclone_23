package MVC.Dao_op;
import MVC.Model.Apprenante;
import MVC.Model.Formateur;
import MVC.Model.Promotion;
import org.hibernate.Session;
import java.util.List;

public class adminDao {

    //    =============>  formateur  <=================

    //    admin add formatuer
    public void addformateur(Formateur formateur) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(formateur);
            session.persist(formateur);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }

    // get data of all formatuer
    public List< Formateur> getAllformatuer() {
        List< Formateur> listOfUser_formateur = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            listOfUser_formateur = session.createQuery("from Formateur ").getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return listOfUser_formateur;
    }

    //   admin update formatuer
    public void updateformatuer(Formateur user) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(user);
            // commit transaction
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }

    //    admin delete formatuer
    public void deleteformateur(int id) {
        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Formateur formateur = session.get(Formateur.class, id);
            if (formateur != null) {
                session.delete(formateur);
                System.out.println("user is deleted");
            }
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }


//    =============>  apprenanate <=================


    //    admin add apprenanate
    public void addapprenanate(Apprenante apprenante) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(apprenante);
            session.persist(apprenante);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // get data of all apprenanate
    public List<Apprenante> getAllapprenanate() {
        List< Apprenante > listOfUser_apprenanate = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            listOfUser_apprenanate = session.createQuery("from Apprenante ").getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listOfUser_apprenanate;
    }

    //   admin update apprenanate
    public void updateapprenanate(Apprenante user) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(user);
            // commit transaction
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    //    admin delete apprenanate
    public void deleteapprenanate(int id) {
        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Apprenante apprenanate = session.get(Apprenante.class, id);
            if (apprenanate != null) {
                session.delete(apprenanate);
            }
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //    =============>  promotion  <=================

    //    admin add promotion
    public void addpromotion(Promotion promotion) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(promotion);
            session.persist(promotion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // get data of all promotion
    public List<Promotion> getAllpromotion() {
        List< Promotion> listOfpromo = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            listOfpromo = session.createQuery("from Promotion").getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listOfpromo;
    }

    //   admin update promotion
    public void updatepromotion(Promotion promotion) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(promotion);
            // commit transaction
            session.persist(promotion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //    admin delete promotion
    public void deletepromotion(int id) {
        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Promotion promotion = session.get(Promotion.class, id);
            if (promotion != null) {
                session.delete(promotion);
            }
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
