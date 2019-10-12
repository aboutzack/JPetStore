<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="/product?id=${product.productId}">Return to ${product.productId}</a>
</div>

<div id="Catalog">
    <form action="/cart" method="post">
        <table>
            <tr>
                <td>${product.description}</td>
            </tr>
            <tr>
                <td><b><input name="itemId" value="${item.itemId}" hidden />${item.itemId}</b></td>
            </tr>
            <tr>
                <td><b><font size="4"> ${item.attribute1}
                    ${item.attribute2} ${item.attribute3}
                    ${item.attribute4} ${item.attribute5}
                    ${product.name} </font></b></td>
            </tr>
            <tr>
                <td>${product.name}</td>
            </tr>
            <tr>
                <td><c:if test="${item.quantity <= 0}">
                    Back ordered.
                </c:if> <c:if test="${item.quantity > 0}">
                    ${item.quantity} in stock.
                </c:if></td>
            </tr>
            <tr>
                <td><fmt:formatNumber value="${item.listPrice}"
                                      pattern="$#,##0.00"/></td>
            </tr>

            <tr>
                <td>
					<input type="submit" value="Add to Cart">
                </td>
            </tr>
        </table>
    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>



