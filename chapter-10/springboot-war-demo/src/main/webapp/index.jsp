<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>SpringBoot JSP</title>
</head>
<body>
<h2>${title}</h2>
<h3><%=request.getAttribute("content") %> </h3>
</body>
</html>