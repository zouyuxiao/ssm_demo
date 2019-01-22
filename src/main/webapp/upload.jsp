<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form action="/file/fileup" method="post" enctype="multipart/form-data">
    <input type="file" name="files" value="文件一"/>
    <input type="file" name="files" value="文件二"/>
    <input type="file" name="files" value="文件三"/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>