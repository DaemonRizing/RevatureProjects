window.onload = () => {
	sendAjaxGet2();
}
const sendAjaxGet2 = () => {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
        	let reqs = JSON.parse(xhr.responseText);
        	display2(reqs);
        }
    }
    xhr.open("GET", "http://localhost:8088/Project1/managerhome");
    xhr.send();
}



function display2(reqs) {
	for(let req in reqs){ 
		let tdEId = document.createElement("td");
		let tdName = document.createElement("td");
		let tdUser = document.createElement("td");
		
		console.log(req);
		
		tdEId.textContext = req.emp_id;
		tdName.textContext = req.f_name + " " + req.l_name;
		tdUser.textContext = req.username;
		
		let row = document.createElement("tr");
		
		row.appendChild(tdEId);
		row.appendChild(tdName);
		row.appendChild(tdUser);
		
		document.getElementByID("table").appendChild(row);
	}
  
        
}


        
