<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form method="post">

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input name="shipToFirstName" value="${order.shipToFirstName}"></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input name="shipToLastName" value="${order.shipToLastName}"></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input name="shipAddress1" value="${order.shipAddress1}"></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input name="shipAddress2" value="${order.shipAddress2}"></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input name="shipCity" value="${order.shipCity}"></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input name="shipState" value="${order.shipState}"></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input name="shipZip" value="${order.shipZip}"></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input name="shipCountry" value="${order.shipCountry}"></td>
		</tr>

	</table>
	<input type="submit" value="Continue">

</form></div>

<%@ include file="../common/IncludeBottom.jsp"%>