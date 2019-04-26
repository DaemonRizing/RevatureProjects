document.addEventListener("DOMContentLoaded", function (e) {
	createOnStartUp();
})
let checkSessionUrl = "http://localhost:8088/Project1/session";
let baseurl = "http://localhost:8088/Project1/employeehomeservlet";
let rurl = "http://localhost:8088/Project1/getreimbursements";

const createOnStartUp = () => {
	sendAjaxGet(checkSessionUrl, populateUser);
	sendAjaxGet(baseurl, displayEmployee);
	sendAjaxGet(rurl, display);
}

let sendAjaxGet = (url, func) => {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

let displayEmployee = (xhr) => {
	let requestArr = JSON.parse(xhr.responseText);
	let table = document.getElementById("tableEmp");

	console.log(requestArr);
	let newBody = document.createElement("tbody");

	table.appendChild(newBody);

	
			let newRow = document.createElement("tr");

			newRow.innerHTML = 
				`<td>${requestArr.employee.id}</td>
				<td>${requestArr.employee.fname}</td>
				<td>${requestArr.employee.lname}</td> 
				<td>${requestArr.employee.username}</td> 
				<td>${requestArr.employee.managerId}</td> 
				`
				table.appendChild(newRow);
}

let display = (xhr) => {
	let requestArr = JSON.parse(xhr.responseText);
	let table = document.getElementById("tableReimburse");

	let newBody = document.createElement("tbody");

	table.appendChild(newBody);

	for (let req in requestArr) {

		for (i in req) {

			let newRow = document.createElement("tr");
				
			newRow.innerHTML = 
				`<td>${requestArr.reimbursement[i].id}</td>
				<td>${requestArr.reimbursement[i].description}</td>
				<td>${requestArr.reimbursement[i].amount}</td> 
				<td>${requestArr.reimbursement[i].status}</td> 
				<td>${requestArr.reimbursement[i].managerId}</td> 
				`
				table.appendChild(newRow);
		}
	}
}




const populateUser = (xhr) => {
	let response = JSON.parse(xhr.response);
	if(response.username != "null"){
		document.getElementById("user").innerHTML = "You are logged in as: "+ response.username;
	} else {
		window.location = "http://localhost:8088/Project1/index";
	}

}
	document.getElementById("displayReimburseTable").style.display = "none";

	document.getElementById("reimbursementView").onclick = function() {
	document.getElementById("displayReimburseTable").style.display = 'block';
	sendAjaxGet("http://localhost:8088/Project1/reimbursementshome", displayReimbursements);
	};

	document.getElementById("reimbursementCreate").onclick = function() {
		document.getElementById("submitoccurred").innerHTML="Request submitted";
	}

//	document.getElementById("empUpdate").style.display = "none";
//
//	document.getElementById("employeeUpdate").onclick = function() {
//		document.getElementById("empUpdate").style.display = "block";
//	}


