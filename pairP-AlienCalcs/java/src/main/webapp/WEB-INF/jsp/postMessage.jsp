<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>New Geek Post</h2>

	<c:url value="/postMessageResult" var="postMessageResultUrl" />
	<form:form action="${postMessageResultUrl}" method="POST" modelAttribute="newPost">
		<div>
			<label for="username">Username</label>
			<form:input type="text" name="username" path="username"/>
			<form:errors path="username"/>
		</div>
		<div>
			<label for="subject">Subject</label>
			<form:input type="text" name="subject" path="subject" />
			<form:errors path="subject"/>
		</div>
		<div>
			<label for="message">Message</label>
			<form:textarea name="message" path="message"></form:textarea>
			<form:errors path="message"/>		
		</div>
		<button type="submit">Submit</button>
	</form:form>
	
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />