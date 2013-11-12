<%@ include file="../includes/header.jsp"%>

<form method="POST" action="authenticate">
   <table>
    <tr>
        <td><label>Official User Name</label></td>
        <td><input name="userName" required="required"/></td>
    </tr>
    <tr>
        <td><label>Password</label></td>
        <td><input type="password" name="password" required="required"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
    </form>
		<p>${result}</p>
		<p>please re-enter the correct user id and password</p>
			

<%@ include file="../includes/footer.jsp"%>