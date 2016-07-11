board.factory('boardService', ['$http', '$location', function($http, $location) {
	var boardService=function(path) {
        this.item={};
        this.path=path;
        this.editItem={};
    };
    
    boardService.prototype={
        save:function() {
            return $http.post(this.path, this.item); //앵귤러 에러는 이쪽 반환값 문제로 인해...JSON으로 파싱해 주던가 리턴값을 받지 말아야 한다.
        }
    };
    
    return {     
        getBoardService:function(path) {
            return new boardService(path);
        }
    };
}]);