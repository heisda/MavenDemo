<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mavenDemo.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/testJquery.js"></script>
<script type="text/javascript">
//alert(Demo.name);
//Demo.sayName("dada");
$(function(){
	alert($("#btn").get(0));
});

</script>
</head>
<body>
${greeting}
<button id="btn" value="Test" onclick="test();" style="height: 20px"></button>
</body>
</html>