<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/json/js/AjaxUtil.js"></script>    
<body>
	<table border="1">
		<tr>
			<th>번호 : </th>
			<td data-col="tmnum"></td>
		</tr>
		<tr>
			<th>영화명 : </th>
			<td ><input type="text" name="tmname"></td>
		</tr>
		<tr>
			<th>개봉일 : </th>
			<td ><input type="date" name="tmstartdat"></td>
		</tr>
		<tr>
			<th>종영일 : </th>
			<td ><input type="date" name="tmenddat"></td>
		</tr>
		<tr>
			<th>등록일자 : </th>
			<td data-col="tmcredat"></td>
		</tr>
		<tr>
			<th>관객수 : </th>
			<td data-col="tmcnt"></td>
		</tr>
		<tr>
			<td colspan="2"><button onclick="updateTM()">수정</button><button onclick="deleteTM()">삭제</button></td>
		</tr>
	</table>
<script>
	var tmnum = <%=request.getParameter("tmnum")%>;
	window.onload = function(){
		var conf = {url:'/json/api/ticket/view',
				params:{tmnum:tmnum},
				cb:callback
				};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res = JSON.parse(res); 
			var tds = document.querySelectorAll('td[data-col]');
			for(var td of tds){
				td.insertAdjacentHTML('afterbegin',res[td.getAttribute('data-col')]);
			}

			var inputs = document.querySelectorAll('input[name]');
			for(var input of inputs){
				var key =  input.getAttribute('name');
				var value = res[input.getAttribute('name')];
				if(key.indexOf('dat')!=-1){
					value = value.substring(0,4) +'-'+value.substring(4,6) +'-'+value.substring(6,8);
				}
				input.value = value;
			}
		} 
	}
	function deleteTM(){
		var conf = {url:'/json/api/ticket',
				params:{tmnum:tmnum},
				method:'DELETE',
				cb:callback
				};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res = JSON.parse(res);
			
			if(res.rCnt==1){ 
				alert('삭제 완료');
				location.href='/json/ticket/list.html';
			}
		}
	}

	function updateTM(){
		var conf = {url:'/json/api/ticket',
				params:{tmnum:tmnum},
				method:'UPDATE',
				cb:callback
				};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res = JSON.parse(res);
			
			if(res.rCnt==1){ 
				alert('수정 완료');
				location.href='/json/ticket/list.html';
			}
		}
	}
</script>
</body>