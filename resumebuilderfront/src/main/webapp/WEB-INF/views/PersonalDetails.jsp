<%@include file="Header.jsp" %>

<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<center>
					<h2 style="font-size: 150%; color: RGB(26, 92, 183);">Personal Details</h2>
				</center>
				<br>
				<form:form method="post" modelAttribute="pdetails" action="${contextPath}/pdetails">
					
					<div class="form-group">
						<label for="firstname">First name</label>
						<form:input type="text" path="firstname" name="firstname"
							class="form-control" required="required" />
						<form:errors path="firstname"></form:errors>
					</div>
					
					<div class="form-group">
						<label for="lastname">Last Name</label>
						<form:input path="lastname" class="form-control"
							name="lastname" required="required" />
						<form:errors path="lastname"></form:errors>
					</div>
					<div class="form-group">
						<label for="gender">Gender</label>
						<form:radiobutton path = "gender" value = "Male" label = "Male" />
                  		<form:radiobutton path = "gender" value = "Female" label = "Female" />
						<form:radiobutton path = "gender" value = "Others" label = "Others" />
						<form:errors path="gender"></form:errors>
					</div>
					<div class="form-group">
						<label for="dob">Date Of Birth</label>
						<form:input path="dob" class="form-control"
							name="dob" required="required" />
						<form:errors path="dob"></form:errors>
					</div>
					<div class="form-group">
						<label for="address">Address</label>
						<form:textarea path="address" rows="3" cols="20" class="form-control"
							name="address" required="required" />
						<form:errors path="address"></form:errors>
					</div>
					<div class="form-group">
						<label for="place">Place</label>
						<form:input path="place" class="form-control"
							name="place" required="required" />
						<form:errors path="place"></form:errors>
					</div>
					<div class="form-group">
						<label for="nationality">Nationality</label>
						<form:input path="nationality" class="form-control"
							name="nationality" required="required" />
						<form:errors path="nationality"></form:errors>
					</div>
					<div class="form-group">
						<label for="maritalStatus">Marital Status</label>
						<form:radiobutton path = "maritalStatus" value = "Single" label = "Single" />
                  		<form:radiobutton path = "maritalStatus" value = "Married" label = "Married" />
						<form:errors path="maritalStatus"></form:errors>
					</div>
					<div class="form-group">
						<label for="knownlanguages">Known Languages</label>
						<form:textarea path="knownlanguages" rows="3" cols="20" class="form-control"
							name="knownlanguages" required="required" />
						<form:errors path="knownlanguages"></form:errors>
					</div>
					<div class="form-group">
						<label for="hobbies">Hobbies</label>
						<form:textarea path="hobbies" rows="3" cols="20" class="form-control"
							name="hobbies"  />
						<form:errors path="hobbies"></form:errors>
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
