<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Solar System Geek Gift Shop</h2>


	<c:forEach items="${products}" var="product">
		<div class="shop">
			<div class="itemImage">
				<c:url var="detailHref" value="/spaceStore/productDetail">
					<c:param name="id">${product.id}</c:param>
				</c:url>
				<c:url value="/img/${product.imageName}" var="image" />
				<a href="${detailHref}"> <img class="shopImg" src="${image}" />
				</a>
			</div>
			<div class="itemName">
				<h4>${product.name}</h4>
			</div>
			<div class="itemPrice">
				<p class="price">${product.price}</p>
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />