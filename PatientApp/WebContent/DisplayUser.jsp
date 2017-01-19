
<%@page import="java.util.Collection"%>
<%@page import="com.psl.model.Facility"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<title>Admin Data</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>


<body>

	<%
		UserBean user = (UserBean)session.getAttribute("User");
	%>
	
	
	
	<div class="container">
		<form class="form-horizontal" role="form" method="post" name="myform">
			<br> <button value="Add New User"
				class="btn btn-primary btn-lg pull-right"
				style="position: relative;"
				onclick="javascript: form.action='registration.jsp';" >Add New User</button> <br>
			<br>

			<div id="wrapper">
				<div id="page-wrapper">
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">

								<!-- /.panel-heading -->
								<div class="panel-body">
									<table width="100%"
										class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>

												<th>Name</th>
												<th>Email</th>
												<th>Facility</th>
												<th>Role</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<%
							Collection<UserBean> userBeanList = (Collection<UserBean>)request.getAttribute("UserList");

							for (UserBean userBean :userBeanList ) {
								
						%>

											<tr>

												<td><%=userBean.getFirstName()%> <%=userBean.getLastName()%></td>
												
								 				<td><%=userBean.getEmail()%></td>
													<td>
														<%for(Facility f : userBean.getFacilities()){
															%>
														<%=f.getName() %>
														<%
														}
														 %>	
														
													
													</td>
												
												<td><%=userBean.getRole()%></td>
												<td>
													<div class="checkbox">
														<%
										String status, val;
											if (userBean.getStatus().equals("Active")) {
												status = "De-Activate";
												val = "Deactive";
											} else {
												status = "Activate";
												val = "Active";
											}
									%>

														<label><input type="checkbox" name="status[]"
															<%=userBean.getFirstName().equals(user.getFirstName()) ? "disabled='disabled'" : ""%>
															id="checked1" value="<%=userBean.getId()%> <%=val%>"><%=status%></label>



													</div>

												</td>

											</tr>
											<%
							}
						%>
										</tbody>

									</table>
									<!-- /.table-responsive -->

									<script type="text/javascript">
                            $(document).ready(function(){
                            	//$('#update').disabled=true;
                            	document.getElementById("update").disabled = true;

                                $('input[type="checkbox"]').click(function(){
                                    if($("[name='status[]']:checked").length > 0){
                                    	document.getElementById("update").disabled = false;
                                        //$('#update').show();
                                    }
                                    else if($("[name='status[]']:checked").length==0){
                                    	//$('#update').hide();
                                    	//alert($("[name='status[]']:checked").length);
                                    	document.getElementById("update").disabled = true;

                                    }
                                    
                                });
                            });
								</script>

									<input type="submit" id="update" value="Update"
										class="btn btn-success pull-right"
										onclick="javascript: form.action='updated.do';">

								</div>
								<!-- /.panel-body -->
							</div>
							<!-- /.panel -->


						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
</body>

</html>