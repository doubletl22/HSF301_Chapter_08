<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Manage Users</title>
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
  <style>
    .btn { margin-right: 8px; }
    .table { margin-bottom: 0; }
    .table th, .table td { text-align: center; }
  </style>
  <script>
    // Script để lấy dữ liệu lên form khi chọn radio
    function selectStudent(id, firstName, lastName, mark) {
      document.getElementById('studentId').value = id;
      document.getElementById('firstName').value = firstName;
      document.getElementById('lastName').value = lastName;
      document.getElementById('mark').value = mark;
    }
  </script>
</head>
<body>
<div class="container mt-4">
  <h3><span>&#128100;</span> Manage Users</h3>
  <div>
    <b>&#128193; User Lists</b>
    <table class="table table-bordered table-striped">
      <thead class="thead-light">
      <tr>
        <th>Choose</th>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Mark</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="student" items="${students}">
        <tr>
          <td>
            <input type="radio" name="selectedStudent"
                   onclick="selectStudent('${student.id}', '${student.firstName}', '${student.lastName}', '${student.mark}')"/>
          </td>
          <td>${student.id}</td>
          <td>${student.firstName}</td>
          <td>${student.lastName}</td>
          <td>${student.mark}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <form action="student" method="post" class="mt-4">
    <table class="table table-bordered">
      <tr>
        <th>Key Name</th>
        <th>Key Value</th>
      </tr>
      <tr>
        <td>ID</td>
        <td><input type="text" id="studentId" name="id" readonly/></td>
      </tr>
      <tr>
        <td>First Name</td>
        <td><input type="text" id="firstName" name="firstName"/></td>
      </tr>
      <tr>
        <td>Last Name</td>
        <td><input type="text" id="lastName" name="lastName"/></td>
      </tr>
      <tr>
        <td>Mark</td>
        <td><input type="text" id="mark" name="mark"/></td>
      </tr>
    </table>
    <button type="submit" name="action" value="add" class="btn btn-primary">Add</button>
    <button type="submit" name="action" value="update" class="btn btn-warning">Update</button>
    <button type="submit" name="action" value="delete" class="btn btn-danger">Delete</button>
  </form>
</div>
</body>
</html>
