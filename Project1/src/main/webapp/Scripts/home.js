let baseurl = "http://localhost:8088/Project1/index";

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

function login(xhr){
	let employees = JSON.parse(xhr.responseText);
	let table = document.getElementById("tableEmp");
	let newRow = document.createElement("tr");
				
		newRow.innerHTML = `<td>${employees.id} </td>
		<td> ${employees.fname} </td>
		<td> ${employees.lname} </td>
		<td> ${employees.username} </td>
		<td> ${employees.managerId} </td>`;
		
		table.appendChild(newRow);	
}



sendAjaxGet(baseurl, displayEmployee);
    
document.getElementById("displayReimburseTable").style.display = "none";

document.getElementById("reimbursementView").onclick = function() {
	document.getElementById("displayReimburseTable").style.display = 'block';
	sendAjaxGet("http://localhost:8088/Project1/reimbursementshome", displayReimbursements);
    };
    
document.getElementById("reimbursementCreate").onclick = function() {
	document.getElementById("submitoccurred").innerHTML="Request submitted";
}

document.getElementById("empUpdate").style.display = "none";

document.getElementById("employeeUpdate").onclick = function() {
	document.getElementById("empUpdate").style.display = "block";
}


