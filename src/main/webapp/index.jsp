<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<h1>注册</h1>
<form action="/api/user/register">
    username:<input type="text" name="username"><br>
    password:<input type="text" name="password"><br>
    <input type="submit" value="注册">
</form>
<hr/>
<h1>登录</h1>
<h3 style="color: red;">${msg}</h3>
<form action="/api/user/login">
    username:<input type="text" name="username"><br>
    password:<input type="text" name="password"><br>
    <input type="submit" value="登录">
</form>
<hr/>
<a href="upload.jsp">上传</a><br/>
<a href="showfile.jsp">下载</a>
</body>
</html>
