/**
 *  
 */
var AjaxUtil = function(conf){
	var method = conf.method?conf.method:'GET';
	var url = conf.url;
	var params = conf.params?JSON.stringify(conf.params):'';
	var type = conf.type?conf.type:'json';
	
	var comErr = function(res){
		alert('[Error Code:' + res.errCode + '] : ' + res.errMsg);
	}
	var comCb = function(res){
		alert(res);
	}
	
	var callback = conf.cb?conf.cb:comCb;
	var errback = conf.err?conf.err:comErr;
	
	var xhr = new XMLHttpRequest();
	
	xhr.cb = callback;
	xhr.err = errback;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				this.cb(xhr.response);
			}else{
				var err = JSON.parse(xhr.response);
				this.err(err);
			}
		}
	}
	this.send = function(){
		if(method=='GET'){
			url += '?params=' + encodeURIComponent(params);
		}
		xhr.open(method,url);
		xhr.send(params);
	}
}