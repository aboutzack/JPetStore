<%@ include file="../common/IncludeTop.jsp" %>


<div id="BackLink">
    <a href="/category?id=${product.categoryId}">Return to ${product.categoryId}</a>
</div>

<div id="Catalog">
    <br>
    <h1>${product.name}</h1>
    <form action="/cart" method="post">
        <table>
            <tr>
                <th>Item ID</th>
                <th>Product ID</th>
                <th>Description</th>
                <th>List Price</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="item" items="${itemList}">
                <tr>
                    <td>
                        <a href="/item?id=${item.itemId}">${item.itemId}</a>
                    </td>
                    <td>${item.product.productId}</td>
                    <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                            ${item.attribute4} ${item.attribute5} ${product.name}
                    </td>
                    <td><fmt:formatNumber value="${item.listPrice}"
                                          pattern="$#,##0.00"/>
                    </td>
                    <td>
                        <input hidden name="itemId" value="${item.itemId}">
                        <input type="submit" value="Add to Cart">
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                </td>
            </tr>
        </table>
    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>





