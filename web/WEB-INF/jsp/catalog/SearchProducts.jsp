<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="/main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>
                    <a href="/product?id=${product.productId}">${product.productId}</a>
                        ${product.description}
                </td>
                <td><b>
                    <a style="color: black" href="">${product.productId}</a>
                    <font color="BLACK"> ${product.productId} </font>
                </b></td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
        </tr>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>




