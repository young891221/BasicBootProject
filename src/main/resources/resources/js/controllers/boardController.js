board.controller('boardController', function($rootScope, $scope, boardService) {
	$scope.board={
		edit:boardService.getBoardService('/insertBoard'), //객체 생성
		save : function() {
			//this.edit.item.content -> this 쓰임세
            if (!confirm("저장하시겠습니까?")) {
                return false;
            }
            this.edit.save().success($rootScope.ajaxCallback({
                successMsg: "저장 성공"
            }));
		}
	};
});