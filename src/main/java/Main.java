import MVC.Dao_op.SessionUtil;
import MVC.Dao_op.apprenanteDao;
import MVC.Dao_op.formateurDao;
import MVC.Model.Apprenante;
import MVC.Model.Classroom;
import MVC.Model.Formateur;
import MVC.Model.Promotion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import javax.persistence.metamodel.EntityType;

import java.util.*;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
    public static List<Apprenante> getall_apprenante() {
        List< Apprenante> listOfclass = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            listOfclass = session.createQuery("from Apprenante ").getResultList();
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

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();


        formateurDao formateurDao=new formateurDao();
        apprenanteDao apprenanteDao=new apprenanteDao();
//        Promotion promotion= formateurDao.getpromo(2);
//        Formateur formateur=formateurDao.getformateur(1);
        Apprenante apprenante =formateurDao.getapp(2);
//        List<Classroom> list_ma_class = apprenanteDao.get_ma_class(apprenante);
        Classroom c = apprenanteDao.get_ma_class(apprenante);

        System.out.println("promotion :  "+c.getPromotionByIdPromo().getYear()+" || class : "+c.getNomClassroom());
    }
}