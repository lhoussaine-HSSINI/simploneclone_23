<%@ page import="MVC.Model.Promotion" %>
<%@ page import="java.util.List" %>
<%@ page import="MVC.Model.Apprenante" %>
<%@ page import="MVC.Dao_op.formateurDao" %>
<%@ page import="MVC.Model.Formateur" %>
<%@ page import="MVC.Model.Classroom" %>
<%@ page import="MVC.Dao_op.apprenanteDao" %><%--
  Created by IntelliJ IDEA.
  User: fahof
  Date: 11/9/2022
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%

    formateurDao formateurDao=new formateurDao();
    apprenanteDao apprenanteDao=new apprenanteDao();
    Promotion promotion= formateurDao.getpromo(2);
    Formateur formateur=formateurDao.getformateur(1);
    Apprenante apprenante =formateurDao.getapp(2);
    Classroom ma_class = apprenanteDao.get_ma_class(apprenante);
%>
<body>
<h1>Hello apprenante : hssini lhoussaine</h1>

<h2>ma promotion : <%=ma_class.getPromotionByIdPromo().getYear()%></h2>

</body>
</html>
