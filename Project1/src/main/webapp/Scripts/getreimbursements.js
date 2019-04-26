document.addEventListener("DOMContentLoaded", function (e) {
	createOnStartUp();
})


let url = "http://localhost:8088/Project1/getreimbursements";
let url2 = "http://localhost:8088/Project1/managerhomeservlet";
const createOnStartUp = () => {
	sendAjaxGet(url, display);
	sendAjaxGet(url2, display2);
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

let display = (xhr) => {
	let requestArr = JSON.parse(xhr.responseText);
	let table = document.getElementById("rTable");
	let selector = document.getElementById("reimburseselect");
	let newBody = document.createElement("tbody");

	table.appendChild(newBody);

	for (let req in requestArr) {

		for (i in req) {
			
				let newRow = document.createElement("tr");
		        let newOp = document.createElement("option");
		    	let resolutionStatus;
		    			
		    		switch (requestArr.reimbursement[i].status) {
		    		case 0 :
		    			resolutionStatus = "Pending";
		    			break;
		    		case 1 :
		    			resolutionStatus = "Approved";
		    			break;
		    		case -1 : 
		    			resolutionStatus = "Denied";
		    			break;
		    		default : 
		    			console.log("Resolution Status Error");
		    		}

			
		    	 if (requestArr.reimbursement[i].status != 0) {
		    		 console.log("If is true: " + requestArr.reimbursement[i].managerId);
		    		 
			newRow.innerHTML = 
				`<td>${requestArr.reimbursement[i].empId}</td>
				<td>${requestArr.reimbursement[i].status}</td>
				<td>${requestArr.reimbursement[i].description}</td> 
				<td>${requestArr.reimbursement[i].amount}</td> 
				<td>${requestArr.reimbursement[i].managerId}</td> 
				`
				table.appendChild(newRow);
		     }else {
		            console.log("If is false: " + requestArr.reimbursement[i].managerId);
		            newOp.value = requestArr.reimbursement[i].id;
		            newOp.text = `${requestArr.reimbursement[i].empId}
		     	   : ${requestArr.reimbursement[i].amount} :
		  			 ${requestArr.reimbursement[i].description}`;
		           
		             selector.appendChild(newOp);
		     }
		}
	}
}

let display2 = (xhr) => {
	let requestArr = JSON.parse(xhr.responseText);
	let table = document.getElementById("table");

	let newBody = document.createElement("tbody");

	console.log(requestArr);
	table.appendChild(newBody);

	for (let req in requestArr) {

		for (i in req) {

			let newRow = document.createElement("tr");

			newRow.innerHTML = 
				`<td>${requestArr.employees[i].fname + " " +  requestArr.employees[i].lname}</td>
				<td>${requestArr.employees[i].username}</td>
				<td>${requestArr.employees[i].id}</td> 
				`
				table.appendChild(newRow);
		}
	}
}



