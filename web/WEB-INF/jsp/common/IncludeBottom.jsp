</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="http://www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.accountBean != null && sessionScope.accountBean.authenticated &&
         sessionScope.accountBean.account.bannerOption}">
            ${sessionScope.accountBean.account.bannerName}
        </c:if>
    </div>
</div>

</body>
</html>