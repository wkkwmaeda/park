<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setHeader("Access-Control-Allow-Origin", "*"); // すべてのオリジンからのアクセスを許可
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); // 許可するHTTPメソッド
    response.setHeader("Access-Control-Max-Age", "3600"); // キャッシュされたオプションの結果を保持する秒数
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept"); // 許可するヘッダー
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認画面</title>
</head>
<body>
<h1>予約が完了しました。</h1>
</body>
</html>