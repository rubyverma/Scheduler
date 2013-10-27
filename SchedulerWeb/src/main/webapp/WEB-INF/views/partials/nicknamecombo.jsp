<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select name="nickName" class="abc" id="nickNameTest" onchange="onNickNameChange()">

	<c:forEach items="${nickname}" var="nickname">
		<option>${ nickname.firstname }</option>
	</c:forEach>

</select>