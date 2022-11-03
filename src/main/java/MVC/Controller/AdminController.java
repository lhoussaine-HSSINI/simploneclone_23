package MVC.Controller;

import MVC.Dao_op.adminDao;
import MVC.Model.Apprenante;
import MVC.Model.Formateur;
import MVC.Model.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminController", value = "/AdminController")
public class AdminController extends HttpServlet {
    private String nom, prenom, username, password, year;
    private  adminDao admin_op;
    private int id_formateur, id_apprenante, id_promotion;
    private RequestDispatcher dispatcher;
    private Formateur user_formateur;
    private Apprenante user_apprenante;
    private Promotion promotion;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//                String servlet_http = String.valueOf(request.getHttpServletMapping());
//                String pathservlet =request.getServletPath();
//                String path = request.getServletPath().substring(1);
//                System.out.println("servlet_http : "+servlet_http);
//                System.out.println("pathservlet : "+pathservlet);
//                System.out.println("path : "+path);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        admin_op=new adminDao();

//                                     neme Operation : add edit delete   ====> path_name_action

        String path_name_action  = request.getServletPath().substring(1);

        switch (path_name_action){
            case "add_formateur":
                nom = request.getParameter("nom");
                prenom  = request.getParameter("prenom");
                username = request.getParameter("username");
                password = request.getParameter("password");
                user_formateur= new Formateur(nom,prenom,username,password);
                user_formateur.setNom(nom);
                user_formateur.setPrenom(prenom);
                user_formateur.setUsername(username);
                user_formateur.setPassword(password);
                admin_op.addformateur(user_formateur);
                dispatcher= request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "edit_formateur":
                id_formateur= Integer.parseInt(request.getParameter("id_formateur"));
                nom = request.getParameter("nom");
                prenom  = request.getParameter("prenom");
                username = request.getParameter("username");
                password = request.getParameter("password");
                user_formateur= new Formateur(id_formateur,nom,prenom,username,password);
                user_formateur.setIdFormateur(id_formateur);
                user_formateur.setNom(nom);
                user_formateur.setPrenom(prenom);
                user_formateur.setUsername(username);
                user_formateur.setPassword(password);

                admin_op.updateformatuer(user_formateur);
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "delete_formateur":
                id_formateur= Integer.parseInt(request.getParameter("id_formateur"));
                admin_op.deleteformateur(id_formateur);
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "add_apprenante":
                nom = request.getParameter("nom");
                prenom  = request.getParameter("prenom");
                username = request.getParameter("username");
                password = request.getParameter("password");
                user_apprenante= new Apprenante(nom,prenom,username,password);
                user_apprenante.setNom(nom);
                user_apprenante.setPrenom(prenom);
                user_apprenante.setUsername(username);
                user_apprenante.setPassword(password);
                admin_op.addapprenanate(user_apprenante);
                dispatcher= request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "edit_apprenante":
                id_apprenante= Integer.parseInt(request.getParameter("id_apprenante"));
                nom = request.getParameter("nom");
                prenom  = request.getParameter("prenom");
                username = request.getParameter("username");
                password = request.getParameter("password");
                user_apprenante= new Apprenante(id_apprenante,nom,prenom,username,password);
                user_apprenante.setIdApprenante(id_apprenante);
                user_apprenante.setNom(nom);
                user_apprenante.setPrenom(prenom);
                user_apprenante.setUsername(username);
                user_apprenante.setPassword(password);

                admin_op.updateapprenanate(user_apprenante);
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "delete_apprenante":
                id_apprenante= Integer.parseInt(request.getParameter("id_apprenante"));
                admin_op.deleteapprenanate(id_apprenante);
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "add_promotion":
                year = request.getParameter("year");
                promotion= new Promotion(year);
                promotion.setYear(year);
                admin_op.addpromotion(promotion);
                dispatcher= request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "edit_promotion":
                id_promotion= Integer.parseInt(request.getParameter("id_promotion"));
                year = request.getParameter("year");
                promotion= new Promotion(id_promotion,year);
                promotion.setIdPromo(id_promotion);
                promotion.setYear(year);

                admin_op.updatepromotion(promotion);
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            case "delete_promotion":
                id_promotion= Integer.parseInt(request.getParameter("id_promotion"));
                admin_op.deletepromotion(id_promotion);
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
                break;
            default:
                dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
                dispatcher.forward(request, response);
        }
        year=null;
        nom=null;
        prenom=null;
        password=null;
        username=null;
        id_formateur=0;
        id_promotion=0;
        id_apprenante =0;
        dispatcher=null;
        admin_op =null;
    }
}
