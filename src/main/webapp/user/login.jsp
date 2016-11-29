<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style></style>
    <!-- jQuery (자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <title>LOGIN</title>
    <style type="text/css">
        .err {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
<h1>로그인 페이지</h1>
<div class="err">
    ${errMSG}
</div>
<form action="result.do">
    <p>
        <label for="id">id:</label>
        <input type="text" name="id" id="id">
    </p>
    <p>
        <label for="pw">pw:</label>
        <input type="text" name="pw" id="pw">
    </p>
    <p>
        <button type="submit">로그인</button>
        <button type="reset">취 소</button>
    </p>
</form>
</body>
</html>
