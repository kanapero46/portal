<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
//現在の時間を表示する
function set2fig(num) {
	   // 桁数が1桁だったら先頭に0を加えて2桁に調整する
	   var ret;
	   if( num < 10 ) { ret = "0" + num; }
	   else { ret = num; }
	   return ret;
	}
	function showClock2() {
	   var nowTime = new Date();
	   var year = nowTime.getFullYear();
	   var month = nowTime.getMonth()+1;
		var day = nowTime.getDay();
	   var nowHour = set2fig( nowTime.getHours() );
	   var nowMin  = set2fig( nowTime.getMinutes() );
	   var nowSec  = set2fig( nowTime.getSeconds() );
	   var msg = year + "年" + month + "月" + day + "日　" + nowHour + ":" + nowMin + ":" + nowSec + " です。";
	   document.getElementById("RealtimeClockArea").innerHTML = msg;
	}
	setInterval('showClock2()',1000);

</script>


</head>
<body>
<h2>index</h2>
<!-- 時計表示エリア -->
<p id="RealtimeClockArea">※Now Loading</p>

<table border="1">
<th>サイト説明</th>
<td><a href="http://www.yahoo.co.jp">http://www.yahoo.co.jp</a>
</td>


</table>

</body>
</html>