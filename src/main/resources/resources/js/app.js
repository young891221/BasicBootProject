var app=angular.module('basic', ['Board']);
app.run(function($rootScope) {
	//$rootScope.contextPath=CONTEXT_PATH;
	
	$rootScope.ajaxCallback=function(obj) {
        return function() {
            if(obj.successMsg) {
                alert(obj.successMsg);
            } else {
            	alert('실패하였습니다.');
            }
            if(obj&&obj.url) {
                location.href=obj.url;
            } else if(resp.redirectUrl) {
                location.href=resp.redirectUrl;
            }
            if(obj.reload && obj.reload===true) {
                location.reload();
            }
        };
    };
    
    $rootScope.cancelConfirm=function(e) {
        if(!confirm("취소하시겠습니까?")) {
            e.preventDefault();
            return false;
        }
    };
    
    $rootScope.goBack=function() {
        if(confirm("취소하시겠습니까?")) {
            history.go(-1);
        }
    };
});