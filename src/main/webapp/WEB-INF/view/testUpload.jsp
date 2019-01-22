<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script>
        function doUpload() {
         var formData = new FormData($("#uploadForm")[0]);
         $.ajax({
         url: '/shapeFile/upload',
         type: 'POST',
         data: formData,
         async: false,
         cache: false,
         contentType: false,
         processData: false,
         success: function (returndata) {
         console.log(returndata);
         },
         error: function (returndata) {
         alert(returndata);
         }
         });
         }
    </script>
</head>
<body>
    <form id="uploadForm" enctype="multipart/form-data">
        <p >指定文件夹名： <input type="text" name="uploadDir" value= ""/></p >
        <p >上传文件： <input type="file" name="file"/></p>
        <p >上传文件： <input type="file" name="file2"/></p>
        <input type="button" value="上传" onclick="doUpload()" />
    </form>
</div>

</body>
</html>





