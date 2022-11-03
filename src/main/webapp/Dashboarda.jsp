<%@ page import="MVC.Dao_op.adminDao" %>
<%@ page import="java.util.List" %>
<%@ page import="MVC.Model.Formateur" %>
<%@ page import="MVC.Model.Apprenante" %>
<%@ page import="MVC.Model.Promotion" %>
<%--
  Created by IntelliJ IDEA.
  User: fahof
  Date: 11/2/2022
  Time: 6:51 AM
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
                            <%--formateur--%>
<h2>ADD FORMATEUR</h2>
<form action="add_formateur" method="post">
    <input type="text" name="nom">
    <input type="text" name="prenom">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="add">
</form>
<h2>all formateur </h2>
<div class="table-responsive">
    <table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Nom</th>
        <th scope="col">Prenom</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <%
        adminDao admin_operation = new adminDao();
        List<Formateur> list_formateur = admin_operation.getAllformatuer();
        for(Formateur f : list_formateur) {
    %>

    <tr scope="row">
        <td><%=f.getIdFormateur()%></td>
        <td><%=f.getNom()%></td>
        <td><%=f.getPrenom()%></td>
        <td><%=f.getUsername()%></td>
        <td><form action="edit_formateur" method="post">
            <input type="text" name="nom">
            <input type="text" name="prenom">
            <input type="text" name="username">
            <input type="text" name="password">
            <input type="hidden" value="<%=f.getIdFormateur()%>" name="id_formateur">
            <input type="submit" value="update">
        </form>
            <form action="delete_formateur" method="post">
                <input type="hidden" value="<%=f.getIdFormateur()%>" name="id_formateur">
                <input type="submit" value="delete">
            </form></td>
    </tr>
    <%}%>
    </tbody>
</table>
</div>


                            <%--apprenante--%>
<h2>ADD apprenante</h2>
<form action="add_apprenante" method="post">
                                <input type="text" name="nom">
                                <input type="text" name="prenom">
                                <input type="text" name="username">
                                <input type="password" name="password">
                                <input type="submit" value="add  apprenate">
                            </form>
<h2>all apprenante </h2>
<div class="table-responsive">
<table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">id</th>
                                        <th scope="col">Nom</th>
                                        <th scope="col">Prenom</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>
                                        <th scope="col">action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        adminDao admin_operation_a = new adminDao();
                                        List<Apprenante> list_apprenante = admin_operation_a.getAllapprenanate();
                                        for(Apprenante a : list_apprenante) {
                                    %>

                                    <tr scope="row">
                                        <td><%=a.getIdApprenante()%></td>
                                        <td><%=a.getNom()%></td>
                                        <td><%=a.getPrenom()%></td>
                                        <td><%=a.getUsername()%></td>
                                        <td><form action="edit_apprenante" method="post">
                                            <input type="text" name="nom">
                                            <input type="text" name="prenom">
                                            <input type="text" name="username">
                                            <input type="text" name="password">
                                            <input type="hidden" value="<%=a.getIdApprenante()%>" name="id_apprenante">
                                            <input type="submit" value="update  apprenate">
                                        </form>
                                            <form action="delete_apprenante" method="post">
                                                <input type="hidden" value="<%=a.getIdApprenante()%>" name="id_apprenante">
                                                <input type="submit" value="delete apprenate">
                                            </form></td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
</div>

                            <%--      promotion       --%>

                            <h2>ADD Promotion</h2>
                            <form action="add_promotion" method="post">
                                <label>promotion : </label>
                                <input type="text" name="year">
                                <input type="submit" value="add  promotion">
                            </form>
                            <h2>all promotion </h2>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">id</th>
                                        <th scope="col">promotion</th>
                                        <th scope="col">action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        adminDao admin_operation_p = new adminDao();
                                        List<Promotion> list_promotion = admin_operation_p.getAllpromotion();
                                        System.out.println(list_promotion);
                                        for(Promotion p : list_promotion) {
                                    %>
                                    <tr scope="row">
                                        <td><%=p.getIdPromo()%></td>
                                        <td><%=p.getYear()%></td>
                                        <td><form action="edit_promotion" method="post">
                                            <input type="text" name="year" placeholder="enter year">
                                            <input type="hidden" value="<%=p.getIdPromo()%>" name="id_promotion">
                                            <input type="submit" value="update  promotion">
                                        </form>
                                            <form action="delete_promotion" method="post">
                                                <input type="hidden" value="<%=p.getIdPromo()%>" name="id_promotion">
                                                <input type="submit" value="delete promotion">
                                            </form></td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
</body>
</html>