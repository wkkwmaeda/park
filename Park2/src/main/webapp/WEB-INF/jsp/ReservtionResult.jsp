<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>予約確認画面</title>
</head>
<body>
    <h1>異世界転生が完了しました。</h1>
	<p>名前: ${sessionScope.cuname}</p>
    <p>電話番号: ${sessionScope.tel}</p>
    <p>車両番号: ${sessionScope.carNumber}</p>
    <p>駐車場チェックイン日: ${sessionScope.pi}</p>
    <p>駐車場チェックアウト日: ${sessionScope.po}</p>
    
    <form action="Return" method="post">
    	<input type="submit" name="button2" value="メインメニューへ戻る">
	</form>
</body>
</html>
