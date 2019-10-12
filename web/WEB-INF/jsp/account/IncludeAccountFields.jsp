<h3>Account Information</h3>

<table>
	<tr>
		<td>First name:</td>
		<td><input name="firstName" value="${account.firstName}"></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input name="lastName" value="${account.lastName}"</td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input name="email" value="${account.email}"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><input name="phone" value="${account.phone}"></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input name="addr1" value="${account.addr1}"></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input name="addr2" value="${account.addr2}"></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input name="city" value="${account.city}"></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input name="state" value="${account.state}"></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input name="zip" value="${account.zip}"></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input name="country" value="${account.country}"></td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
			<select name="languagePreference">
				<option value="english"<c:if test="${account.languagePreference == 'english'}">selected="selected"</c:if>>english</option>
				<option value="japanese"<c:if test="${account.languagePreference == 'japanese'}">selected="selected"</c:if>>japanese</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td>
			<select name="favoriteCategory">
				<option value="FISH"<c:if test="${account.favouriteCategoryId == 'FISH'}">selected="selected"</c:if>>FISH</option>
				<option value="DOGS"<c:if test="${account.favouriteCategoryId == 'DOGS'}">selected="selected"</c:if>>DOGS</option>
				<option value="REPTILES"<c:if test="${account.favouriteCategoryId == 'REPTILES'}">selected="selected"</c:if>>REPTILES</option>
				<option value="CATS"<c:if test="${account.favouriteCategoryId == 'CATS'}">selected="selected"</c:if>>CATS</option>
				<option value="BIRDS"<c:if test="${account.favouriteCategoryId == 'BIRDS'}">selected="selected"</c:if>>BIRDS</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td>
			<input name="listOpt" type="checkbox"<c:if test="${account.listOption}">checked</c:if>>
		</td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td>
			<input name="bannerOpt" type="checkbox"<c:if test="${account.bannerOption}">checked</c:if>>
		</td>
	</tr>

</table>

