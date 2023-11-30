<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>予約フォーム</title>

    <!-- カレンダー表示のために追加 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.0/fullcalendar.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.0/fullcalendar.min.js"></script>

    <script>
        $(document).ready(function() {
            var pi, po;
            var today = moment(); // 今日の日付

            // カレンダーの初期化
            $('#calendar').fullCalendar({
                selectable: true,
                validRange: {
                    start: today.format('YYYY-MM-DD'), // 今日以降の日付から選択可能
                },
                select: function(start, end, jsEvent, view) {
                    pi = start;
                    po = end;

                    // カレンダーが選択された日付を隠しフィールドに設定
                    $('#pi').val(pi.format('YYYY-MM-DD'));
                    $('#po').val(po.format('YYYY-MM-DD'));

                    alert('チェックイン: ' + pi.format('YYYY-MM-DD') + '\nチェックアウト: ' + po.format('YYYY-MM-DD'));
                }
            });
        });
    </script>
</head>
<body>
<form id="reservationForm" action="ReservResultServlet" method="post">
    <!-- 名前入力フォーム -->
    名　　　前: <input type="text" name="cuname" required><br>

    <!-- 電話番号入力フォーム -->
    電話番号: <input type="tel" name="tel" required><br>
    
    <!-- 車両番号入力フォーム -->
    車両番号: <input type="text" name="carNumber" required><br>
    
    <!-- カレンダー表示領域 -->
    <div id="calendar"></div><br>
    
    <!-- チェックイン日とチェックアウト日を保持する隠しフィールド -->
    <input type="hidden" id="pi" name="pi">
    <input type="hidden" id="po" name="po">
    
    <!-- 予約ボタンと戻るボタン -->
    <input type="submit" name="button2" value="予約">
</form>
<form action="Return" method="post">
    <input type="submit" name="button2" value="メインメニューへ戻る">
</form>
</body>
</html>
