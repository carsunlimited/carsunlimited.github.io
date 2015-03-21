<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>Add a note</title>

<%@ include file="/jsp/include.jsp"%>

<script type="text/javascript">
	/** Function for form validation */
	$(document).ready(function() {

		$("#myForm").submit(function() {

			noteError = $(".noteError");
			var note = $("#text");

			if (note.val() == null || note.val() == "") {
				note.addClass("needsFilled");
				noteError.fadeIn(750);
			} else {
				note.removeClass("needsFilled");
				noteError.fadeOut(750);
			}

			if ($(":input").hasClass("needsfilled")) {
				return false;
			} else {
				return true;
			}
		});

		$(":input").focus(function() {
			if ($(this).hasClass("needsfilled")) {
				$(this).val("");
				$(this).removeClass("needsfilled");
			}
		});
	});
</script>

</head>
<body>
	<div id="everything">
		<div id="top_header"></div>
		<div id="content">
			<div id="header">

				<!-- HEADER CONTENT-->
				<h1>Insert Note Text</h1>
			</div>
			<!-- END class="header" -->
			<div id="body">
				<!-- MYFORM CONTENT-->
				<div id="error" class="noteError" align="center">Note must be
					filled in</div>
				</br>
				<form:form name="myForm" id="myForm" method="post">

					<center>
						<form:textarea rows="15" cols="40" path="text"></form:textarea>
						</br> <a href="<c:url value="show_note_records.html" />">Cancel</a> <input
							class="submit" type="submit" name="submit" value="Save" />
					</center>

				</form:form>
				<!-- End myForm content -->
			</div>
		</div>
	</div>
</body>
</html>