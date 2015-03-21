 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Service Record List</title>

<%@ include file="/jsp/include.jsp"%>

</head>
<body>

	<%
		/** Formats the cost field to a double type with two decimal places */
		final String decFormat = "#0.00";
		DecimalFormat df = new DecimalFormat(decFormat);
	%>
	<div id="everything">
		<div id="top_header">
			Welcome,
			<c:forEach items="${serviceRecordList}" var="name"
				varStatus="loopStatus">
				<c:if test="${loopStatus.count<2}">
					<c:out value="${name.firstName}" />
					<c:out value="${name.lastName}" />
					</br>
				</c:if>
			</c:forEach>

			<a href="<c:url value="logged-out.html" />">Logout</a>
		</div>
		<div id="content">
			<div id="header">

				<!-- HEADER CONTENT-->
				<h1>My Service History Report</h1>
				<p>
					<i>[ file your personal vehicle maintenance reports ]</i>
				</p>

			</div>
			<!-- END class="header" -->

			<!-- BODY CONTENT-->
			<div id="body">
				<div class="middle">
					<table>
						<thead>
							<tr>
								<th>Vehicle Make <a
									href="<c:url value="show_service_records.html?sortType=1" />"><img
										class="sort" width="11" src="images/sort_asc.png" /><a
										href="<c:url value="show_service_records.html?sortType=2" />"><img
											class="sort" width="11" src="images/sort_dec.png" /></th>
								<th>Vehicle Model <a
									href="<c:url value="show_service_records.html?sortType=9" />"><img
										class="sort" width="11" src="images/sort_asc.png" /><a
										href="<c:url value="show_service_records.html?sortType=10" />"><img
											class="sort" width="11" src="images/sort_dec.png" /></th>
								<th>Service Cost <a
									href="<c:url value="show_service_records.html?sortType=11" />"><img
										class="sort" width="11" src="images/sort_asc.png" /><a
										href="<c:url value="show_service_records.html?sortType=12" />"><img
											class="sort" width="11" src="images/sort_dec.png" /></th>
								<th>Service Date <a
									href="<c:url value="show_service_records.html?sortType=3" />"><img
										class="sort" width="11" src="images/sort_asc.png" /><a
										href="<c:url value="show_service_records.html?sortType=4" />"><img
											class="sort" width="11" src="images/sort_dec.png" /></th>
								<th>Description <a
									href="<c:url value="show_service_records.html?sortType=5" />"><img
										class="sort" width="11" src="images/sort_asc.png" /><a
										href="<c:url value="show_service_records.html?sortType=6" />"><img
											class="sort" width="11" src="images/sort_dec.png" /></th>
								<th style="width: 100px">Satisfied? <a
									href="<c:url value="show_service_records.html?sortType=7" />"><img
										class="sort" width="11" src="images/sort_asc.png" /><a
										href="<c:url value="show_service_records.html?sortType=8" />"><img
											class="sort" width="11" src="images/sort_dec.png" /></th>
							</tr>
						</thead>

						<tbody>
							<%-- Loops though list of service records and adds it to a row --%>
							<c:forEach items="${serviceRecordList}" var="record"
								varStatus="loopStatus">

								<%-- Checks index for even or odd for to color rows different --%>
								<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
									<td>${record.make}</td>
									<td>${record.model}</td>

									<td>$ <%
										ServiceRecord record = (ServiceRecord) pageContext
													.getAttribute("record");
									%> <%=df.format(record.getCost())%>
									</td>

									<td>${record.date}</td>
									<td>${record.description}</td>

									<td><c:choose>
											<c:when test="${record.satisfied}">
												<img class="thumbs" src="images/thumbs_up.png" width="27%" />
											</c:when>
											<c:otherwise>
												<img class="thumbs" src="images/thumbs_down.png" width="27%" />
											</c:otherwise>
										</c:choose></td>

									<td width="20"><input type="image"
										src="images/edit_icon.png"
										onClick="location.href='<c:url value="edit_service_record.html?id=${record.id}" />'" /></td>
									<td width="20"><input type="image"
										src="images/note_icon.png"
										onClick="location.href='<c:url value="show_note_records.html?id=${record.id}" />'" /></td>
									<td width="20"><input type="image"
										src="images/delete_icon.png"
										onClick="location.href='<c:url value="delete_service_record.html?id=${record.id}" />'" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<input type="image" src="images/add_icon.png" value=""
						class="addButton"
						onClick="location.href='add_service_record.html'"></input>
				</div>
				<!-- END class="middle" -->
			</div>
			<!--FOOTER CONTENT -->
			<center class="footer">
				<a href="mailto:simon.gorial@gmail.com""> Contact me </a>| My
				Service History � 2012 All Rights Reserved
			</center>
			<!-- END class="footer" -->
		</div>
</body>
</html>