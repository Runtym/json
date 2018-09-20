/**
 * 
 */


function makeJson(query){
	var objs = document.querySelectorAll(query);
	var param = {};
	for(var i=0;i<objs.length;i++){
		var obj = objs[i];
		var key = obj.getAttribute('data-name');
		var vali = obj.getAttribute('data-val');
		var value = obj.value;
		if(vali){
			if(vali=='num'){
				if(isNaN(new Number(value))){
					alert('숫자로 넣어야지 임마.')
					obj.focus();
					return false;
				}
			}
		}
		param[key] = value;
	}
	return JSON.stringify(param);
}

window.onload = function(){
	var btns = document.querySelectorAll('button[data-json]');
	for(var i=0;i<btns.length;i++){
		var btn = btns[i];
		btn.onclick = function(){
			var url = this.getAttribute('data-json');
			var xhr = new XMLHttpRequest();
			param = makeJson('input[data-name]');
			if(param){
				xhr.onreadystatechange = function(){
					if(xhr.readyState==xhr.DONE){
						if(xhr.status==200){
							alert(xhr.responseText);
						}else{
							alert(xhr.responseText);
						}
					}
				}
				xhr.open('GET',url + '?param=' + encodeURIComponent(param));
				xhr.send();
				alert(1);
			}
		}
	}
}