<#import "/layout/layoutTop.ftl" as layout>
<@layout.layoutTop>
<div class='container'>
	<div class='panel panel-primary dialog-panel'>
		<div class='panel-heading'>
			<h5>회원가입</h5>
		</div>
		<div class='panel-body'>
			<form role="form" class='form-horizontal' name="change_record" method="post"
				action="/join">
				<div class='form-group'>
					<label class='control-label col-md-2 col-md-offset-2'
						for='id_accomodation'>Login Id</label>

					<div class='col-md-6'>
						<div class='form-group'>
							<div class='col-md-11'>
								<input type="text" class="form-control" name="loginId"
									id="loginId" placeholder="ID or Email" 
									onchange="idcheck()" maxlength="20" required>
							</div>
						</div>
					</div>
					<p class="col-md-2">
						<button class="btn btn-primary btn-block" type="button"
							onclick="idcheck()">ID중복확인</button>
					</p>
					<p class="col-md-4 col-md-offset-4">
						<span id="idcheckLayer"></span>
					</p>
				</div>
				<div class='form-group'>
					<label class='control-label col-md-2 col-md-offset-2'
						for='id_accomodation'>Password</label>

					<div class='col-md-6'>
						<div class='form-group'>
							<div class='col-md-11'>
								<input type="password" class="form-control" name="loginPw"
									id="loginPw" placeholder="8자리이상"
									onchange="" required>
							</div>
						</div>
					</div>
				</div>
				<div class='form-group'>
					<label class='control-label col-md-2 col-md-offset-2'
						for='id_title'>Name</label>
					<div class='col-md-6'>
						<div class='form-group'>
							<div class='col-md-11'>
								<input type="text" class="form-control" name="name"
									id="name" placeholder="홍길동"
									onchange="" required>
							</div>
						</div>
					</div>
				</div>
				<div class='form-group'>
					<label class='control-label col-md-2 col-md-offset-2'
						for='id_adults'>Phone</label>
					<div class='col-md-6'>
						<div class='form-group'>
							<div class='col-md-11'>
								<input type="text" class="form-control" name="phone"
									id="phone" placeholder="010-0000-0000"
									onchange="" required>
							</div>
						</div>
					</div>
				</div>
				<div class='form-group'>
					<label class='control-label col-md-2 col-md-offset-2'
						for='id_email'>E-mail</label>
					<div class='col-md-6'>
						<div class='form-group'>
							<div class='col-md-11'>
								<input class='form-control' name="email" id='email'
									placeholder='E-mail' type='text' onchange=""
									required>
							</div>
						</div>
					</div>
				</div>
				<div class='form-group'>
					<label class='control-label col-md-2 col-md-offset-2' for='id_pets'>Address</label>
					<p class="col-md-2 col-md-offset-4">
						<button class="btn btn-primary btn-block" type="button"
							data-toggle="modal" data-target=".modal_post"
							onclick="showhide();">주소찾기</button>

					</p>
				</div>
				<!-- disable는 제출되지 않는다 즉 값이 전달되지 않음. *중요 -->
				<div class='form-group'>
					<div class="col-md-offset-4 col-md-6">
						<div class='col-md-11'>
							<input class='form-control' name="mbrZipcode" id='Zipcode'
								type='text' placeholder='우편번호' value ="" readonly="readonly">
						</div>


						<div class="enter hidden-xs hidden-sm"></div>
						<div class='col-md-11'>
							<input name="mbrAddress_1" class='form-control' id='address'
								placeholder='주소' type='text' value ="" readonly="readonly">
						</div>
						<div class="enter hidden-xs hidden-sm"></div>

						<div class="col-md-11">
							<input name="mbrAddress_2" class="form-control" 
								 placeholder='나머지 주소' type="text"  />
						</div>
						
						<div class="enter"></div>
					</div>
				</div>

				<div class='form-group pull-right'>
					<div style="padding-right: 50px;">
						<button type="submit" class='btn btn-lg btn-primary'>
							<i class="glyphicon glyphicon-edit"></i>
						</button>
						<button class='btn btn-lg btn-danger'
							onClick="javascript:history.go(-1)">
							<i class="glyphicon glyphicon-remove"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

</@layout.layoutTop>