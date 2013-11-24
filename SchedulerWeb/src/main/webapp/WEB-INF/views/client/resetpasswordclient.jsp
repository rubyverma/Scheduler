<%@ include file="../includes/header.jsp"%>
	 
   
<form method="POST" action="saveTemporaryPassword">
        <div class="form-group">
    <label for="exampleInputEmail1">Client Email address</label>
    <input type="email" class="form-control" id="inputEmail" placeholder="Enter email" name = "emailAddress">
  </div>
  <input type="submit" value="Submit" />
        
   
    </form>
    <%@ include file="../includes/footer.jsp"%>