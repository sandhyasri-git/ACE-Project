<%@include file="Header.jsp" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<center>
					<h2 style="font-size: 150%; color: RGB(26, 92, 183);">Educational Details</h2>
				</center>
				<br>
				<form:form method="post" modelAttribute="eddetails" action="${contextPath}/eddetails">
					<form:input path="pdetails.userid" type="hidden"/>
					<div class="form-group">
						<label for="collegeName">College Name:</label>
						<form:input type="text" path="collegeName" name="collegeName"
							class="form-control" required="required" />
						<form:errors path="collegeName"></form:errors>
					</div>
					
					<div class="form-group">
						<label for=type">Type</label>
						<form:input type="text" path="type" class="form-control"
							name="type" required="required" />
						<form:errors path="type"></form:errors>
					</div>
					<div class="form-group">
						<label for="subjects">Subjects</label>
						<form:input path="subjects" class="form-control"
							name="subjects" required="required" />
						<form:errors path="subjects"></form:errors>
					</div>
					<div class="form-group">
						<label for="year">Year</label>
						<form:input path="year" class="form-control"
							name="year" required="required" />
						<form:errors path="year"></form:errors>
					</div>
					<div class="form-group">
						<label for="board">Board</label>
						<form:input path="board" class="form-control"
							name="board" required="required" />
						<form:errors path="board"></form:errors>
					</div>
					<div class="form-group">
						<label for="obtainedMarks">obtainedMarks</label>
						<form:input path="obtainedMarks" class="form-control"
							name="obtainedMarks" required="required" />
						<form:errors path="obtainedMarks"></form:errors>
					</div>
					<div class="form-group">
						<label for="totalMarks">TotalMarks</label>
						<form:input path="totalMarks" class="form-control"
							name="totalMarks" required="required" />
						<form:errors path="totalMarks"></form:errors>
					</div>
					<div class="form-group">
						<label for="percentage">Percentage</label>
						<form:input path="percentage" class="form-control"
							name="percentage" required="required" />
						<form:errors path="percentage"></form:errors>
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
