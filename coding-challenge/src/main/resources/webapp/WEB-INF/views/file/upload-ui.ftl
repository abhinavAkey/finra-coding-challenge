<!DOCTYPE HTML>
<html>
	<#include "../header.ftl">
<body>
	<div id="layout">
		<#include "../coding-challenge-menu.ftl">
	    <div class="main" style="margin-left:55px; max-width:850px;">
	    	<div class="file-request">
	 		<h1> Add File & Meta Data</h1>
			    <form class="pure-form pure-form-aligned" name="file-request" id="file-request-form"
			          action="" method="post" enctype="multipart/form-data">
			        <fieldset>
			
			            <div class="pure-control-group">
			                <label for="firstName">Fist Name</label>
			                <input type="text" name="firstName" id="firstName" placeholder="First Name" maxlength="30"
			                       required>
			                <span class="pure-form-message-inline">Required</span>
			
			            </div>
			            
			            <div class="pure-control-group">
			                <label for="lstName">Last Name</label>
			                <input type="text" name="lastName" id="lastName" placeholder="Last Name" maxlength="30"
			                       required>
			                <span class="pure-form-message-inline">Required</span>
			
			            </div>
			            
			            <div class="pure-control-group">
			                <label for="phoneNumber">Phone Number</label>
			                <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number" maxlength="10"
			                       required>
			                <span class="pure-form-message-inline">Required</span>
			
			            </div>
			            
			             <div class="pure-control-group">
			                <label for="email">Email</label>
			                <input type="text" name="email" id="email" placeholder="Email" maxlength="30"
			                       required>
			                <span class="pure-form-message-inline">Required</span>
			
			            </div>
			            
			            <div class="pure-control-group">
			                <label for="file">File to Upload</label>
			                <input type="file" name="file" class="file-upload" id="file"
			                       required>
			                <span class="pure-form-message-inline">Required</span>
			
			            </div>
			
			            <div class="pure-controls">
			                <button type="reset" value="Reset" class="button-warning pure-button">Reset fields
			                </button>
			
			                <button type="submit" class="pure-button pure-button-primary">Add File Meta Data
			                </button>
			            </div>
			        </fieldset>
			    </form>
			</div>
		</div>
	</div>
</body>
</html>