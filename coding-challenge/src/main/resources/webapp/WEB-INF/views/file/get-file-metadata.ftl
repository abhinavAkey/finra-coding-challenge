<!DOCTYPE HTML>
<html>
	<#include "../header.ftl">
<body>
	<div id="layout">
		<#include "../coding-challenge-menu.ftl">
	    <div class="main" style="margin-left:55px; max-width:850px;">
	    	<div class="file-request">
	 		<h1> Get File & Meta Data</h1>
			    <div class="container">
				    <div class="row col-md-12">
					<#if fileAndMetaDataResponses?has_content >
				        <table class="table table-bordered" style="width: 85%;">
				            <thead>
				                <tr>
			                     <th>First Name</th>
			                     <th>Last Name</th>
			                     <th>Phone Number</th>
			                     <th>Email</th>
			                     <th>File Name</th>
				                </tr>
				            </thead>
			                 <#list fileAndMetaDataResponses as fileAndMetaDataResponse>
			                 	<tr>             
				                    <td><label  class="form-control" id="${fileAndMetaDataResponse.firstName}" name="${fileAndMetaDataResponse.firstName}">${fileAndMetaDataResponse.firstName}</label></td>
				                    <td><label  class="form-control" id="${fileAndMetaDataResponse.lastName}" name="${fileAndMetaDataResponse.lastName}">${fileAndMetaDataResponse.lastName}</label></td>
				                    <td><label  class="form-control" id="${fileAndMetaDataResponse.phoneNumber}" name="${fileAndMetaDataResponse.phoneNumber}">${fileAndMetaDataResponse.phoneNumber}</label></td>
				                    <td><label  class="form-control" id="${fileAndMetaDataResponse.email}" name="${fileAndMetaDataResponse.email}">${fileAndMetaDataResponse.email}</label></td>
				                    <td><label  class="form-control" id="${fileAndMetaDataResponse.fileName}" name="${fileAndMetaDataResponse.fileName}">${fileAndMetaDataResponse.fileName}</label></td>
				                </tr>
			                 </#list>	           
				        </table>
					</#if>  
				</div>
			</div>
		</div>
	</div>
</body>
</html>