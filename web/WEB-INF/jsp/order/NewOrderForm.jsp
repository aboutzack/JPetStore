<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="/confirmorder" method="post">

	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td><stripes:select name="cardType">
				<stripes:options-collection
					collection="${actionBean.creditCardTypes}" />
			</stripes:select></td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><input name="creditCard" value="${order.creditCard}" /></td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><input name="expiryDate" value="${order.expiryDate}"></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input name="billToFirstName" value=${order.billToFirstName} type="text"></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input name="billToLastName" value=${order.billToLastName} type="text"></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input name="billAddress1" value="${order.billAddress1}" type="text" size="40"></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input name="billAddress2" value="${order.billAddress2}" type="text" size="40"></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input name="billCity" value="${order.billCity}" type="text"></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input name="billState" value="${order.billState}" type="text" size="4"></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input name="billZip" value="${order.billZip}" type="text" size="10"></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input name="billCountry" value="${order.billCountry}" type="text" size="15"></td>
		</tr>


		<tr>
			<td colspan=2>
				<input type="checkbox" name="shippingAddressRequired" >
				Ship to different address...
			</td>
		</tr>
	</table>
		<input type="submit" value="Continue" />

	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>