/**
 * 
 */
var Request = function(){
	var params = {};
	var init = function(){
		var url = unescape(location.href);
		var paramList = url.substring(url.lastIndexOf('?')+1).split('&');
		for(var param of paramList){
			var kye = param.split('=')[0];
			var value = param.split('=')[1];
			params[kye] = value;
		}
	}
	
	this.getParameter = function(key){
		return params[key];
	}
	init();
};