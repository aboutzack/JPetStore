<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">

    <form action="/signup" method="post">
        <h3>User Information</h3>

        <table>
            <tr>
                <td>User ID:</td>
                <td><input name="username"/></td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input name="password"/></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input name="repeatedPassword"/></td>
            </tr>
            <p style="color: red">${requestScope.msg}</p>
        </table>

        <%@ include file="IncludeAccountFields.jsp" %>

		<br>
        <input name="editAccount" value="Save Account Information" type="submit"><br>

    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>