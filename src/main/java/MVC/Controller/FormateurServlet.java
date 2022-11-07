package MVC.Controller;

import MVC.Dao_op.adminDao;
import MVC.Dao_op.formateurDao;
import MVC.Model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FormateurServlet", value = "/FormateurServlet")
public class FormateurServlet extends HttpServlet {

    private String classe, titleBrief, descriptionBrief;
    private  formateurDao formateurDao;
    private int id_formateur, id_apprenante, id_promo, deadlineBrief;
    private RequestDispatcher dispatcher;
    private Apprenante apprenante;
    private Formateur formateur;
    private Promotion promotion;
    private Classroom classroom;
    private Brief brief;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path_name_action  = request.getServletPath().substring(1);
        System.out.println(path_name_action);
        if (path_name_action.equals("Homef")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Homef.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginController loginController=new LoginController();
        String path_name_action  = request.getServletPath().substring(1);

        switch(path_name_action){
            case "add_apprenante_ma_class":
                classe=request.getParameter("class");
                id_apprenante= Integer.parseInt(request.getParameter("id_apprenante"));
                id_promo= Integer.parseInt(request.getParameter("id_promo"));

                formateurDao=new formateurDao();
                apprenante=formateurDao.getapp(id_apprenante);
                promotion=formateurDao.getpromo(id_promo);
                formateur=formateurDao.getformateur(1);
                classroom = new Classroom(classe,promotion, formateur, apprenante);
                classroom.setNomClassroom(classe);
                classroom.setPromotionByIdPromo(promotion);
                classroom.getFormateurByIdFormateur(formateur);
                classroom.setApprenanteByIdApprenante(apprenante);
                formateurDao.addclass(classroom);
                break;
            case "add_brief":
                titleBrief = request.getParameter("titleBrief");
                descriptionBrief = request.getParameter("descriptionBrief");
                deadlineBrief   = Integer.parseInt(request.getParameter("deadlineBrief"));

                formateurDao formateur_op=new formateurDao();
                Promotion    p = formateur_op.getpromo(2);
                Formateur    f = formateur_op.getformateur(1);
                System.out.println(p.getIdPromo());
                System.out.println(f.getIdFormateur());
                List<Classroom> ma_class =  formateur_op.get_ma_class(p,f);
                Classroom classroom1  = new Classroom();
                for(Classroom c: ma_class){
                    System.out.println(c);
                    classroom1 =c;
                    break;
                }

                brief = new Brief(titleBrief, descriptionBrief, deadlineBrief, classroom1);
                brief.setTitleBrief(titleBrief);
                brief.setDescriptionBrief(descriptionBrief);
                brief.setDeadlineBrief(deadlineBrief);
                brief.setClassroomByIdClassroom(classroom1);
                formateur_op.addbrief(brief);
                break;
            case "update_brief":
                System.out.println(path_name_action);
                break;
            case "delete_brief":
                System.out.println(path_name_action);
                break;
            default:
                RequestDispatcher dispatcher = request.getRequestDispatcher("Homef.jsp");
                dispatcher.forward(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Homef.jsp");
        dispatcher.forward(request, response);

    }
}
