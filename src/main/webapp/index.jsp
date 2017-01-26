<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
    <form method="GET" action="/searchUser">
        <input type="submit" name="showAll" value="Show All" /><br />
        <input type="text" placeholder="Last Name" name="lastName"/>
        <input type="submit" name="search" value="Search By Last Name" />
    </form>
</body>
</html>