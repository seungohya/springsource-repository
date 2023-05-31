<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
</head>
<body>
<!-- form 안에 file 요소가 존재할 경우 enctype 속성을 "multipart/form-data"로 설정해야 합니다. -->
<form action="" method="post" enctype="multipart/form-data">
  <div>
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" />
  </div>
  <div>
    <label for="file">File:</label>
<input type="file" name="file" id="file" multiple accept="image/*,.txt" />
  </div>
  <div>
    <input type="submit" value="Upload" />
  </div>
</form>
</body>
</html>
