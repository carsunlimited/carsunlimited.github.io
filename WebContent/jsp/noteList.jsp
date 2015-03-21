<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>You Notes</title>

<%@ include file="/jsp/include.jsp"%>

</head>
<body>
	<div id="everything">
		<div id="top_header"></div>
		<div id="content">
			<a href="<c:url value="show_service_records.html" />"> <img
				width="45" src="images/home.png" />
			</a>
			<!-- HEADER CONTENT-->
			<div class="header">

				<h1>My Personal Note Taker</h1>
				</br>
			</div>
			<!-- END class="header" -->

			<!-- MIDDLE CONTENT-->
			<div id="body">
				<div class="middle">
					<table width="100%">
						<thead>

							<tr>
								<th>[ Make multiple notes for each serviced vehicle ]</th>
							</tr>
						<tbody>

							<%-- Loops though list of notes and adds it to a row --%>
							<c:forEach items="${noteList}" var="note" varStatus="loopStatus">

								<%-- Checks index for even or odd for to color rows different --%>
								<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
									<td>${note.text}</td>
									<td width="20"><input type="image"
										src="images/delete_icon.png"
										onClick="location.href='<c:url value="delete_note_record.html?id=${note.id}" />'" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</thead>

					</center>
					<input type="image" src="images/add_icon.png" width="30px" value=""
						onClick="location.href='add_note_record.html'"></input>
				</div>
				<!-- END class="body" -->
			</div>
		</div>
	</div>
</body>

</html>