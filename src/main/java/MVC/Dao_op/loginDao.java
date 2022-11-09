package MVC.Dao_op;
import MVC.Model.Admin;
import MVC.Model.Apprenante;
import MVC.Model.Formateur;
import org.hibernate.Session;

public class loginDao {
    public Boolean insertAdmin(String username, String password) {
        Admin admin = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            admin = (Admin) session.createQuery("SELECT U FROM Admin U WHERE U.username = :username ").setParameter("username", username).uniqueResult();
            if (admin != null && admin.getPassword().equals(password)) {
                return true;
            }
            session.persist(admin);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("error admin");
        }
        return false;
    }
    public Boolean inserformateur(String username, String password) {
        Formateur formateur = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            formateur = (Formateur) session.createQuery("SELECT U FROM Formateur U WHERE U.username = :username ").setParameter("username", username).uniqueResult();
            if (formateur != null && formateur.getPassword().equals(password)) {
                return true;
            }
            session.persist(formateur);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("error formateur ");
        }
        return false;
    }



    public Boolean inserapprenante(String username, String password) {
        Apprenante apprenante = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            apprenante = (Apprenante) session.createQuery("SELECT U  FROM Apprenante U WHERE U.username = :username").setParameter("username", username).uniqueResult();
            System.out.println(apprenante.getUsername());
            System.out.println(apprenante.getPassword());
            System.out.println(apprenante.getClassroomsByIdApprenante());
            if (apprenante.getPassword().equals(password)) {
                return true;
            }
            session.persist(apprenante);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("error apprenante");
        }
        return false;
    }
}