
var Demo = function(){
    var version = 1;
    var log = function(param){
        alert(version + param);
    };
    return {
        name:"heisda",
        sayName: function(to){
            log(to);
        }
    };
}();