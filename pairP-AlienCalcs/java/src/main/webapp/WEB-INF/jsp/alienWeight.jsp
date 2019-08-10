
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Alien Weight Calculator</h2>

	<c:url value="/alienWeightResult" var="alienWeightResultUrl" />
	<form action="${alienWeightResultUrl}">
		<div>
			<label for="planetName">Choose a Planet</label>
			<select name="planetName">
				<c:forEach var="planet" items="${planets}">
					<option value="${planet.name}">${planet.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label for="earthWeight">Enter Your Earth Weight</label>
			<input type="text" name="earthWeight" />
		</div>
		<button type="submit">Calculate Weight</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
