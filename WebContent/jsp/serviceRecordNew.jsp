<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>Add Service Record</title>

<%@ include file="/jsp/include.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {

		// The text to show up within a field when it is incorrect
		modelError = $(".modelError");
		costError = $(".costError");
		costErrorFormat = $(".costErrorFormat");
		dateError = $(".dateError");
		dateErrorFormat = $(".dateErrorFormat");

		var model = $("#model");
		var cost = $("#cost");
		var date = $("#date");

		$("#myForm").submit(function() {
			//Validate required fields

			if (isEmpty(model.val())) {
				model.addClass("needsfilled");
				modelError.fadeIn(750);
			} else {
				modelError.fadeOut(750);
				model.removeClass("needsfilled");

			}

			if (isEmpty(cost.val())) {
				cost.addClass("needsfilled");
				costError.fadeIn(750);
			} else if (isNaN(cost.val())) {
				costErrorFormat.fadeIn(750);
				cost.addClass("needsfilled");

			} else {
				costError.fadeOut(750);
				costErrorFormat.fadeOut(750);
				cost.removeClass("needsfilled");

			}

			if (isEmpty(date.val())) {
				date.addClass("needsfilled");
				dateError.fadeIn(750);
			} else if (isDateMatch(date.val())) {
				date.addClass("needsfilled");
				dateErrorFormat.fadeIn(750);
			} else {
				date.removeClass("needsfilled");
				dateError.fadeOut(750);
				dateErrorFormat.fadeOut(750);
			}

			//if any inputs on the page have the class 'needsfilled' the form will not submit
			if ($(":input").hasClass("needsfilled")) {
				return false;
			} else {
				return true;
			}
		});

		// Clears the input field when you click on them
		$(":input").focus(function() {
			if ($(this).hasClass("needsfilled")) {
				$(this).val("");
				$(this).removeClass("needsfilled");
			}
		});
	});

	function isEmpty(x) {
		if (x == null || x == "") {
			return true;
		} else {
			return false;
		}
	}

	function isDateMatch(date) {

		// date checker for four digit year
		var datePattern = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;
		// check and see if the date is a valid format
		var dateMatch = date.match(datePattern);

		if (dateMatch == null) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<div id="everything">
		<div id="top_header">
			<h2>Insert Record Details</h2>
		</div>
		<div id="content">
			<a href="<c:url value="show_service_records.html" />"> <img
				width="45" src="images/home.png" />
			</a>
			<!-- HEADER CONTENT-->
			<div class="header"></div>
			<!-- END class="header" -->

			<!-- MYFORM CONTENT-->
			<div id="body">

				<center>
					<div class="my-form">
						<li id="error" class="modelError">Model is a required field</li>
						<li id="error" class="costError">Cost is a required field</li>
						<li id="error" class="dateError">Date is a required field</li>
						<li id="error" class="costErrorFormat">Cost not a correct
							format!</li>
						<li id="error" class="dateErrorFormat">Date not a correct
							format!</li> </br> </br>

						<%-- Using the Spring form tags to send field values to form backing 
							object for pre-populating edit form --%>
						<form:form name="myForm" id="myForm" method="post">

							<label>Make</label>
							<form:input path="make" id="make" />
							<label> <i>*</i>Model
							</label>
							<form:input path="model" id="model" />
							<label> <i>*</i>Cost
							</label>
							<form:input path="cost" id="cost" />
							<label> <i>*</i>Date
							</label>
							<form:input path="date" id="date" />
							<label>Description </label>
							<form:textarea rows="3" cols="24" path="description"></form:textarea>
							<label>Satisfied? </label>
							<form:checkbox path="satisfied" id="satisfied" />
							<input class="submit" type="submit" name="submit" value="Save" />
							<p id="error">There were errors on the form, please make sure
								all fields are fill out correctly.</p>
						</form:form>
				</center>
			</div>
			<!-- End myForm content -->
		</div>
	</div>
	</div>
</body>
</html>