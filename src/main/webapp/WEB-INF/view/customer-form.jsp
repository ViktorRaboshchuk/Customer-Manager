<%--
  Created by IntelliJ IDEA.
  User: Viktor
  Date: 02.06.2018
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" >
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Save Customer</title>


</head>

<body>


        <h2>CRM - Customer Relationship Manager</h2>



    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName" /></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email" /></td>
            </tr>

            </tbody>
        </table>
<br>
        <input type="submit" value="Save" class="btn btn-outline-dark" />
    </form:form>


<br>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>



</body>

</html>






