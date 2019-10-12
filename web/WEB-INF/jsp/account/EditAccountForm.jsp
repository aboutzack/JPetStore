<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="/myaccount" method="post">

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td>${account.username}</td>
			<td><input hidden="hidden" name="username" value="${account.username}"></td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input name="password" type="password" /></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input name="repeatedPassword" type="password" /></td>
		</tr>
		<p style="color: red">${requestScope.msg}</p>
	</table>
	<%@ include file="IncludeAccountFields.jsp"%>

<%--	<stripes:submit name="editAccount" value="Save Account Information" />--%>

	<input name="editAccount" value="Save Account Information" type="submit"><br>
	<a href="/listorders">My Orders</a>

<%@ include file="../common/IncludeBottom.jsp"%>
	</form>
</div>