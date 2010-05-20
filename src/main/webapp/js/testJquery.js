
(function(){
	window.JQ = function(params){
		return new JQ.fn.init(params);
	}
	
	JQ.fn = JQ.prototype = {
		version: "1.0",
		init: function(params){
			return new Array(params);
		}
	}
	
	function testInit(params){
		return {
			log:function(params){
				alert("log:" + params);
			},
			say:function(params){
				alert("say:" + params)
			}
		};
	};
	
})();
