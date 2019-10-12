<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="/main">Return to Main Menu</a>
</div>

<div id="Catalog">
<br/>
	<h1 style="text-align: center">${categoryId}</h1>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>
                    <a href="/product?id=${product.productId}">${product.productId}</a>
                </td>
                <td>${product.name}
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


