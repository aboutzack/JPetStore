<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="StyleSheet" href="../static/css/jpetstore.css" type="text/css" media="screen"/>

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
</head>
<body>
<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="/main"><img src="../static/image/logo-topbar.gif"></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="/cart"><img align="middle" name="img_cart" src="../static/image/cart.gif"/></a>

            <img align="middle" src="../static/image/separator.gif"/>

            <c:if test="${sessionScope.authenticated == null}">
                <a href="/signin">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.authenticated}">
                <a href="/signout">Sign Out</a>
                <img align="middle" src="../static/image/separator.gif"/>
                <a href="/myaccount">My Account</a>
            </c:if>
            <img align="middle" src="../static/image/separator.gif"/> <a href="../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">

            <form action="/search" method="post">

                <input type="text" name="keyword" size="14"/>
                <input type="submit" name="searchProducts" value="Search"/>
                <span style="color: red">${searchMsg}</span>
            </form>
        </div>

    </div>

    <div id="QuickLinks">
        <a href="/category?id=fish"><img src="../static/image/sm_fish.gif"/></a>
        <img src="../static/image/separator.gif"/>
        <a href="/category?id=dogs"><img src="../static/image/sm_dogs.gif"/></a>
        <img src="../static/image/separator.gif"/>
        <a href="/category?id=reptiles"><img src="../static/image/sm_reptiles.gif"/></a>
        <img src="../static/image/separator.gif"/>
        <a href="/category?id=cats"><img src="../static/image/sm_cats.gif"/></a>
        <img src="../static/image/separator.gif"/>
        <a href="/category?id=birds"><img src="../static/image/sm_birds.gif"/></a>
    </div>

</div>
<div id="Content">

