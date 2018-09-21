<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>영화</th>
			<th>가격</th>
			<th>개봉일</th>
			<th>종료일</th>
			<th>등록일</th>
			<th>관객수</th>
		</tr>
	</thead>
	<tbody id="tbody">
	</tbody>
</table>
<script>
	window.onload = function(){
		var json = '<%=request.getAttribute("json")%>';

		var res = JSON.parse(json);
		alert(`page : ${res.page}`);
		var html = '';
		if(res.list.length==0){
			html += '<tr><td colspan="7">등록된 영화가 없습니다.</td></tr>';
		}
		for(var tm of res.list){
			html += '<tr>';
			html += '<td>' + tm.tmnum + '</td>';
			html += '<td><a href="/json/ticket/view.jsp?tmnum=' + tm.tmnum + '">' + tm.tmname + '</a></td>';
			html += '<td>' + tm.tmprice + '</td>';
			html += '<td>' + tm.tmstartdat + '</td>';
			html += '<td>' + tm.tmenddat + '</td>';
			html += '<td>' + tm.tmcredat + '</td>';
			html += '<td>' + tm.tmcnt + '</td>';
			html += '</tr>';
		}
		tbody.insertAdjacentHTML('afterbegin',html)
		
	}
</script>
</body>