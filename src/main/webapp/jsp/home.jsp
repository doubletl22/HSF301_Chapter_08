<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h2>Student List</h2>
<form action="add" method="post">
    Name: <input type="text" name="name" required />
    Email: <input type="text" name="email" required />
    <button type="submit">Add</button>
</form>
<br/>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Delete</th></tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td><a href="delete/${s.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
