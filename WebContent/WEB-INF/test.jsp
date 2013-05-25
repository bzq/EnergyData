<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	      <p>Ceci est une page générée depuis une JSP.</p>
        <p>
         <c:out value="test" />
           <ul>
<%--            		<li>Maison: ${ household.idHouseHold }</li> --%>
           		<c:forEach items="${listMeasures}" var="measure" varStatus="status">
					<li>Date:<c:out value="${measure['date']}" /> ,Valeur: <c:out value="${measure['energyValue']}" /></li>
				</c:forEach>
           		
           </ul> 
        </p>
</body>
</html>