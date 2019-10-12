<%@ include file="../common/IncludeTop.jsp" %>

<div id="Welcome">
    <div id="WelcomeContent">
        <c:if
            test="${account != null }">
        <c:if test="${authenticated}">
            Welcome ${account.firstName}!
        </c:if>
    </c:if></div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
			<a href="/category?id=fish"><img src="../static/image/fish_icon.gif"/></a>
			<br/>
            Saltwater, Freshwater <br/>

			<a href="/category?id=dogs"><img src="../static/image/dogs_icon.gif"/></a>
			<br/>
            Various Breeds <br/>

			<a href="/category?id=cats"><img src="../static/image/cats_icon.gif"/></a>
			<br/>
            Various Breeds, Exotic Varieties <br/>

			<a href="/category?id=reptiles"><img src="../static/image/reptiles_icon.gif"/></a>
			<br/>
            Lizards, Turtles, Snakes <br/>

			<a href="/category?id=birds"><img src="../static/image/birds_icon.gif"/></a>
			<br/>
            Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250"
                      href="/category?id=birds" shape="RECT"/>
                <area alt="Fish" coords="2,180,72,250"
                      href="/category?id=fish" shape="RECT"/>
                <area alt="Dogs" coords="60,250,130,320"
                      href="/category?id=dogs" shape="RECT"/>
                <area alt="Reptiles" coords="140,270,210,340"
                      href="/category?id=reptiles" shape="RECT"/>
                <area alt="Cats" coords="225,240,295,310"
                      href="/category?id=cats" shape="RECT"/>
                <area alt="Birds" coords="280,180,350,250"
                      href="/category?id=birds" shape="RECT"/>
            </map>
            <img height="355" src="../static/image/splash.gif" align="middle"
                 usemap="#estoremap" width="350"/></div>
    </div>

    <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

