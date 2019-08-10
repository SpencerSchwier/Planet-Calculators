<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Solar System Geek Gift Shop</h2>
	<div class="shopCart">
		<table>
			<tr>
				<th> </th>
				<th>Name</th>
				<th>Price</th>
				<th>Qty.</th>
				<th>Total</th>
			</tr>
			
			<c:forEach items="${customerCart.productsInCart}" var="item">
			<tr>
				<td>
					<c:url value="/img/${item.imageName}" var="image" />
					<img class="shopImg" src="${image}"/>
				</td>
				<td>${item.name} </td>
				<td>${item.price} </td>
				<td>${item.quantity} </td>
				<td><fmt:formatNumber value="${item.productTotal}" type="currency"/> </td>
			</tr>
			</c:forEach>
			<tr>
				<td> </td>
				<td> </td>
				<td> </td>
				<td> Grand Total </td>
				<td><fmt:formatNumber value="${customerCart.shoppingCartTotal}" type="currency"/> </td>
			</tr>
			<tr>
				<td> </td>
				<td> </td>
				<td> </td>
				<td> </td>
				<td> 
					<c:url value="/thankYou" var="checkout"/>
					<a Href="${checkout}">Check Out</a>
				</td>
			</tr>
		</table>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

