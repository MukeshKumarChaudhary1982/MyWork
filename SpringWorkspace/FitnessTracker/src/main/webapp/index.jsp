<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<body>
<h2>Hello World!</h2>
<h1>Welome Uset: <sec:authentication property="name"/></h1>
<a href="/FitnessTracker/addMinutes.html">Add Minutes</a>
<a href="/FitnessTracker/addGoal.html">Add Goal Minutes</a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="/FitnessTracker/addGoal.html">Admin Add Goal Minutes</a>
</sec:authorize>
</body>
</html>
