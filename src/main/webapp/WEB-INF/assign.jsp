<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Affection</title>
</head>
<body>
<h1>Employee Affection</h1>
<form action="/admin/assign" method="post">
    <label for="employee">Employee Name:</label>
    <select id="employee" name="employeeId">
        <c:forEach items="${employees}" var="employee">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <label for="project">Project Name:</label>
    <select id="project" name="projectId">
        <c:forEach items="${projects}" var="project">
            <option value="${project.id}">${project.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Assign</button>
</form>
</body>
</html>
