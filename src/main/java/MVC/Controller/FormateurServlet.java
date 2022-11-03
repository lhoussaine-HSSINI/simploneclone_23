package MVC.Controller;

import MVC.Dao_op.adminDao;
import MVC.Dao_op.formateurDao;
import MVC.Model.Apprenante;
import MVC.Model.Classroom;
import MVC.Model.Formateur;
import MVC.Model.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FormateurServlet", value = "/FormateurServlet")
public class FormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String classe=request.getParameter("class");
        System.out.println(classe);
        int id_apprenante= Integer.parseInt(request.getParameter("id_apprenante"));
        System.out.println(id_apprenante);
        int id_promo= Integer.parseInt(request.getParameter("id_promo"));
        System.out.println(id_promo);
        LoginController loginController=new LoginController();
//        int id_formateur=loginController.id;
//        System.out.println(id_formateur);
        formateurDao formateurDao=new formateurDao();
        Apprenante apprenante=formateurDao.getapp(id_apprenante);
        Promotion promotion=formateurDao.getpromo(id_promo);
        Formateur formateur=formateurDao.getformateur(1);
        Classroom classroom = new Classroom(classe,promotion, formateur, apprenante);
        classroom.setNomClassroom(classe);
        classroom.setPromotionByIdPromo(promotion);
        classroom.getFormateurByIdFormateur(formateur);
        classroom.setApprenanteByIdApprenante(apprenante);
        formateurDao.addclass(classroom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Homef.jsp");
        dispatcher.forward(request, response);



    }
}
