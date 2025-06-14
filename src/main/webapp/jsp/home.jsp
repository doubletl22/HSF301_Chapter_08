<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    <style>
        .btn { margin-right: 8px; }
        .table { margin-bottom: 0; }
        .table th, .table td { text-align: center; }
    </style>
    <script>
        function selectStudent(id, name, email) {
            document.getElementById('studentId').value = id;
            document.getElementById('studentName').value = name;
            document.getElementById('studentEmail').value = email;
        }
    </script>
</head>
<body>
<div class="container mt-4">
    <h3>Manage Students</h3>
    <div>
        <b>Student Lists</b>
        <table class="table table-bordered table-striped">
            <thead class="thead-light">
            <tr>
                <th>Choose</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${students}">
                <tr>
                    <td>
                        <input type="radio" name="selectedStudent"
                               onclick="selectStudent('${s.id}', '${s.name}', '${s.email}')"/>
                    </td>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <form action="student" method="post" class="mt-4">
        <input type="hidden" id="studentId" name="id"/>
        Name: <input type="text" id="studentName" name="name"/>
        Email: <input type="text" id="studentEmail" name="email"/>
        <button type="submit" name="action" value="add" class="btn btn-primary">Add</button>
        <button type="submit" name="action" value="update" class="btn btn-warning">Update</button>
        <button type="submit" name="action" value="delete" class="btn btn-danger">Delete</button>
    </form>
</div>
</body>
</html>
