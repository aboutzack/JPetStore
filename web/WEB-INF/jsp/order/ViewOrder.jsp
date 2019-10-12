<%@ include file="../common/IncludeTop.jsp" %>

<%--<c:if test="${msg}">--%>
    <ul>
        <li>Thank you, your order has been submitted.</li>
    </ul>
<%--</c:if>--%>

<div id="BackLink">
    <a href="/main">Return to Main Menu</a>
</div>
    <div id="Catalog">

        <table>
            <tr>
                <th align="center" colspan="2">Order #${order.orderId}
                    <fmt:formatDate value="${order.orderDate}"
                                    pattern="yyyy/MM/dd hh:mm:ss"/></th>
            </tr>
            <tr>
                <th colspan="2">Payment Details</th>
            </tr>
            <tr>
                <td>Card Type:</td>
                <td><c:out value="${order.cardType}"/></td>
            </tr>
            <tr>
                <td>Card Number:</td>
                <td><c:out value="${order.creditCard}"/>
                </td>
            </tr>
            <tr>
                <td>Expiry Date (MM/YYYY):</td>
                <td><c:out value="${order.expiryDate}"/></td>
            </tr>
            <tr>
                <th colspan="2">Billing Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td><c:out value="${order.billToFirstName}"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><c:out value="${order.billToLastName}"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><c:out value="${order.billAddress1}"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><c:out value="${order.billAddress2}"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><c:out value="${order.billCity}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><c:out value="${order.billState}"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><c:out value="${order.billZip}"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><c:out value="${order.billCountry}"/></td>
            </tr>
            <tr>
                <th colspan="2">Shipping Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td><c:out value="${order.shipToFirstName}"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><c:out value="${order.shipToLastName}"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><c:out value="${order.shipAddress1}"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><c:out value="${order.shipAddress2}"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><c:out value="${order.shipCity}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><c:out value="${order.shipState}"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><c:out value="${order.shipZip}"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><c:out value="${order.shipCountry}"/></td>
            </tr>
            <tr>
                <td>Courier:</td>
                <td><c:out value="${order.courier}"/></td>
            </tr>
            <tr>
                <td colspan="2">Status: <c:out value="${order.status}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <table>
                        <tr>
                            <th>Item ID</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total Cost</th>
                        </tr>
                        <c:forEach var="lineItem" items="${order.lineItems}">
                            <tr>
                                <td>
                                <a href="">${lineItem.item.itemId}</a>
                                </td>
                                <td><c:if test="${lineItem.item != null}">
                                    ${lineItem.item.attribute1}
                                    ${lineItem.item.attribute2}
                                    ${lineItem.item.attribute3}
                                    ${lineItem.item.attribute4}
                                    ${lineItem.item.attribute5}
                                    ${lineItem.item.product.name}
                                </c:if> <c:if test="${lineItem.item == null}">
                                    <i>{description unavailable}</i>
                                </c:if></td>

                                <td>${lineItem.quantity}</td>
                                <td><fmt:formatNumber value="${lineItem.unitPrice}"
                                                      pattern="$#,##0.00"/></td>
                                <td><fmt:formatNumber value="${lineItem.total}"
                                                      pattern="$#,##0.00"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <th colspan="5">Total: <fmt:formatNumber
                                    value="${order.totalPrice}" pattern="$#,##0.00"/></th>
                        </tr>
                    </table>
                </td>
            </tr>

        </table>

    </div>
</div>

    <%@ include file="../common/IncludeBottom.jsp" %>
