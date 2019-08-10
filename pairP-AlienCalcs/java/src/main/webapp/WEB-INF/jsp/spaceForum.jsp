<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content" class="posts">
	<h2>Solar System Geek Forum</h2>
	
	<c:url value="/postMessage" var="postMessageResultUrl" />
	<a class="centered" href="${postMessageResultUrl}">Post a Message</a>
	
	<c:forEach items="${forumPosts}" var="post">
		<div class="posts post">
		   <h4>${post.subject}</h4>
		   <fmt:formatDate type="date" dateStyle="medium" value="${post.javaDatePosted}" var="date"/>
		   <p>by ${post.username} on ${date}</p>
		   <p class="message">${post.message}</p>
		</div>
	</c:forEach>
	
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />