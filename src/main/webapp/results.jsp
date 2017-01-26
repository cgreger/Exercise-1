<%@include file="head.jsp"%>

<html><body>

<%--Pretty up the results!--%>
<div class="container-fluid">

    <table border="solid">
        <th>ID</th><th>First Name</th><th>Last Name</th><th>DOB</th><th>Age</th>
        <c:forEach items="${users}" var="user">

            <tr>
                <td>${user.userid}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.calculateUserAge()}</td>
            </tr>

        </c:forEach>
    </table>


</div>

</body>
</html>
