<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Solar System Geek Gift Shop</h2>
	
		<div class="detail">
			<div class="detailImg">
				<c:url value="/img/${product.imageName}" var="image" />
				<img src="${image}"/>
			</div>	
			<div class="detailContent">
				<c:url var="formAction" value="/spaceStore/shoppingCart"/>
				<form method="POST" action="${formAction}">
				<input type="hidden" name="product" value="${product.id}">
					
				
				   <h3>${product.name}</h3>
				   <p class="detailPrice">${product.price}</p>
				   <p>${product.description}</p>
				<c:url var="formAction" value="/spaceStore/shoppingCart" />
					<label for="quantity">Quantity To Buy</label>
					<input type="text" name="quantity"/>
					<button type="submit">Add to Cart</button> 
				</form>
			</div>
		</div>
		
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />