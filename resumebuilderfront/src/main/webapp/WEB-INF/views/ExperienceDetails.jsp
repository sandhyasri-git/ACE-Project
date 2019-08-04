<%@include file="Header.jsp" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<center>
					<h3 style="font-size: 150%; color: RGB(26, 92, 183);">Experience Details</h3>
				</center>
				<br>
				<form:form method="post" modelAttribute="expdetails" action="${contextPath}/expdetails">
					<form:input path="pdetails.userid" type="hidden"/>
					<div class="form-group">
						<label for="employer">Employer</label>
						<form:input type="employer" path="employer" name="employer"
							class="form-control" required="required" />
						<form:errors path="employer"></form:errors>
					</div>
					
					<div class="form-group">
						<label for="designation">designation</label>
						<form:input path="designation" class="form-control"
							name="designation" required="required" />
						<form:errors path="designation"></form:errors>
					</div>
					<div class="form-group">
						<label for="joiningDate">JoiningDate</label>
						<form:input path="joiningDate" class="form-control"
							name="joiningDate" required="required" />
						<form:errors path="joiningDate"></form:errors>
					</div>
					<div class="form-group">
						<label for="leavingDate">LeavingDate</label>
						<form:input path="leavingDate" class="form-control"
							name="leavingDate"  />
						<form:errors path="leavingDate"></form:errors>
					</div>
					<center>
						<input type="submit" name="_eventId_submit"
							class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input
							type="reset" name="_eventId_cancel" value="CANCEL"
							class="btn btn-danger" />
					</center>
					
				</form:form>
			</div>
			<div class="col-sm-4">
			<button id="print">Print</button>
			</div>
		</div>
	</div>
</div>
