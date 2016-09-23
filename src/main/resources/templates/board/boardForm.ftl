<#import "/layout/layout.ftl" as layout>
<@layout.layout>

	<#-- body -->
	<div class="cover-container" ng-controller="boardController as board"> 
		<div class="span8 offset2">
			<br><br>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<div class="pull-right">
							<select class="form-control" ng-model="board.edit.item.status">
								<option value="">--게시판상태--</option>
								<option value="0">임시저장</option>
								<option value="1">현재공지</option>
							</select>
							<select class="form-control" ng-model="board.edit.item.group">
								<option value="">--서비스분류--</option>
								<option value="young">영재게시판</option>
								<option value="sso">소현게시판</option>
							</select>
						</div>
					</tr>
				</thead>
			</table>

			<table class="table table-striped">
				<tr>
					<th class="active">Title</th>
					<td><input type="text" class="span11 form-control"
						placeholder="Text input" ng-model="board.edit.item.title"></td>
				</tr>

				<tr>
					<th class="active">Content</th>
					<td><textarea ng-model="board.edit.item.content"
							class="span11 form-control input-sm ckeditor" id="message"
							placeholder="Message" maxlength="140" rows="7"
							style="height: 200px;"></textarea> 
						<span class="help-block"></span>
						<a type="button" class="btn" href="javascript:popupOpen();" >이미지 올리기</a>
					</td>
				</tr>
			</table>

			<br style="clear: both">
			<p class="pull-right">
				<button type="button" class="btn"
					onClick="javascript:window.location.href='/'">All List</button>
				<button type="button" class="btn btn-inverse" ng-click="board.save()">Insert</button>
			</p>
		</div>
	</div>
	
</@layout.layout>