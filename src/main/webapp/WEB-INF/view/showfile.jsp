<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<table>
    <c:forEach items="${files }" var="file">
        <tr>
            <td>${file.key}</td>
            <td>
                <c:forEach items="${file.value}" var="filename">
                    <ul>
                        <li><a href="/file/downfile?filename=${filename}&id=${file.key}">${filename}</a></li>
                    </ul>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>