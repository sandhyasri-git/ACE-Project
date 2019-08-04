<%@include file="Header.jsp" %>
 <div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<center>
					<h2 style="font-size: 350%; color: RGB(26, 92, 183);">Sign
							Up</h2>
				</center>
				<br>
				<form:form method="post" modelAttribute="registrationdetails" action="adduser">
					
					<div class="form-group">
						<label for="emailid">Email</label>
						<form:input type="email" path="emailId" name="emailId"
							class="form-control" required="required" />
						<form:errors path="emailId"></form:errors>
					</div>
					
					<div class="form-group">
						<label for="password">Password</label>
						<form:password path="password" class="form-control"
							name="password" required="required" />
						<form:errors path="password"></form:errors>
					</div>
					<div class="form-group">
						<label for="cpassword">Re Enter Password</label>
						<form:password path="cpassword" class="form-control"
							name="cpassword" required="required" />
						<form:errors path="cpassword"></form:errors>
					</div>
					<div class="form-group">
						<label for="mobileNo">mobileNo</label>
						<form:password path="mobileNo" class="form-control"
							name="mobileNo" required="required" />
						<form:errors path="mobileNo"></form:errors>
					</div>
					<center>
						<input type="submit" name="_eventId_submit"
							class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input
							type="reset" name="_eventId_cancel" value="CANCEL"
							class="btn btn-danger" />
					</center>
				</form:form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%>