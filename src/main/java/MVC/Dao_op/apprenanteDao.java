package MVC.Dao_op;

import MVC.Model.Apprenante;
import MVC.Model.Classroom;
import MVC.Model.Formateur;
import MVC.Model.Promotion;
import org.hibernate.Session;

import java.util.List;

public class apprenanteDao {
    //    get one  class of this apprenante
    public Classroom get_ma_class(Apprenante apprenante) {
        Classroom classroom = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            classroom = (Classroom) session.createQuery("select U from Classroom U where U.apprenanteByIdApprenante=:apprenante").setParameter("apprenante",apprenante).getSingleResult();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classroom;
    }
}
