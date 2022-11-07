<%@ page import="MVC.Dao_op.adminDao" %>
<%@ page import="MVC.Model.Apprenante" %>
<%@ page import="java.util.List" %>
<%@ page import="MVC.Model.Promotion" %>
<%@ page import="MVC.Dao_op.formateurDao" %>
<%@ page import="MVC.Model.Formateur" %>
<%@ page import="MVC.Model.Classroom" %>
<%@ page import="java.util.Collections" %>
<%@ page import="static MVC.Dao_op.formateurDao.getAllclass" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fahof
  Date: 11/2/2022
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<form action="add_apprenante_ma_class" method="post">

    <label> select one promo </label>
    <select class="custom-select" name="id_promo">
        <%
            adminDao admin_operation_p = new adminDao();
            List<Promotion> list_promotion = admin_operation_p.getAllpromotion();
            for(Promotion p : list_promotion) {
        %>
        <option value="<%=p.getIdPromo()%>"><%=p.getYear()%></option>
        <%}%>
    </select>
    <label> select one classroom </label>
    <select class="custom-select" name="class" >
        <option value="Robert Noyce">Robert Noyce</option>
        <option value="James Gosling">James Gosling</option>
        <option value="Brendan Eich">Brendan Eich</option>
        <option value="Ada Lovelace">Ada Lovelace</option>
        <option value="Margaret Hamilton">Margaret Hamilton</option>
        <option value="Alan Turing">Alan Turing</option>
    </select>
    <label> select one apprenant </label>
    <select class="custom-select" name="id_apprenante">
            <%
                adminDao admin_operation_a = new adminDao();
                List<Apprenante> list_apprenante = admin_operation_a.getAllapprenanate();
                List<Classroom> list_cllassroms = getAllclass();
                ArrayList<String> email_apprenante = new ArrayList<>();
                for(Classroom  app: list_cllassroms) {
                    email_apprenante.add(app.getApprenanteByIdApprenante().getUsername());
                }
                for(Apprenante a : list_apprenante) {
                    if (!email_apprenante.contains(a.getUsername())) {
            %>

            <option value="<%=a.getIdApprenante()%>">   <%=a.getNom()%>    </option>
            <%
                        }
                    }
            %>
        </select>
    <input type="submit" value="add">
</form>
<h1>list of classrom</h1>
<table class="table">
    <thead>
    <th scope="col">N°</th>
    <th scope="col">nom</th>
    <th scope="col">prenom</th>
    <th scope="col">username</th>
    </thead>
   <tbody>
    <%
        int i = 1;
        formateurDao formateurDao=new formateurDao();
        adminDao adminDao=new adminDao();
        List<Formateur> formateurs = Collections.singletonList(formateurDao.getformateur(1));
        Promotion promotion= formateurDao.getpromo(2);
        Formateur formateur=formateurDao.getformateur(1);
        List<Classroom> list_ma_apprenanate = formateurDao.getall_ma_apprenanate(promotion,formateur,"java 1");
//        for(Formateur f: formateurs){
//            for(Classroom classroom: f.getClassroomsByIdFormateur()){
        for(Formateur f: formateurs){
            for(Classroom classroom: list_ma_apprenanate){
    %>
    <tr>
        <th scope="col"><%=i %></th>
        <td><%=classroom.getApprenanteByIdApprenante().getNom()%></td>
        <td><%=classroom.getApprenanteByIdApprenante().getPrenom()%></td>
        <td><%=classroom.getApprenanteByIdApprenante().getUsername()%></td>
    </tr>
    <%
            i++;
            }
    %>
    <%}%>
    </tbody>
</table>

<h2>add brief to my class </h2>

<form action="add_brief" method="post">
    <input class="form-control" type="text" name="titleBrief" placeholder="titleBrief"/>
    <textarea class="form-control"  name="descriptionBrief">  description Brief ...</textarea>
    <input class="form-control" type="number" name="deadlineBrief" placeholder="deadlineBrief"/>
    <input class="form-control btn btn-primary" type="submit" value="add brief">
</form>
</body>
</html>
