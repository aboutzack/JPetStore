<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <%--    <stripes:form beanclass="org.csu.jpetstore.web.actions.AccountActionBean" focus="">--%>
    <%--        <p>Please enter your username and password.</p>--%>
    <%--        <p>Username:<stripes:text name="username" value="j2ee"/> <br/>--%>
    <%--            Password:<stripes:password name="password" value="j2ee"/></p>--%>
    <%--        <stripes:submit name="signon" value="Login"/>--%>
    <%--    </stripes:form>--%>
    <form action="signin" method="post">
        <p>Please enter your username and password.</p>
        <table>
            <tr><td align="right">Username:<input type="text" name="username"/></td></tr>
            <tr><td align="right">Password:&nbsp<input type="password" name="password"/></td></tr>
            <tr><td align="right">Captcha:&nbsp&nbsp&nbsp&nbsp<input type="text" name="captcha" style="width: 60px">
                <img src="/captcha"/></td></tr>
        </table>
        <p style="color: red">${requestScope.msg}</p>
            <input type="submit" name="signin" value="signin"/>
    </form>
    Need a user name and password?
    <a href="/signup">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

