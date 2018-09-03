var ws = new WebSocket("ws://127.0.0.1:8080/WebSocketTCSNinja/endpoint");
//var temp;
var rowCount =1;
ws.onopen = function() {
    alert("Opened!");
    ws.send("Hello Server");
};

ws.onmessage = function (evt) {
    alert("Message: " + evt.data);
    var data = JSON.parse(evt.data);
    /*document.getElementById("Temp").innerHTML = data.Humidity;
    document.getElementById("Hum").innerHTML = data.Temperature;
    document.getElementById("Date").innerHTML = data.timeStamp;*/
    myFunction(data);
    //temp = evt.data;
};

ws.onclose = function() {
    alert("Closed!");
};

ws.onerror = function(err) {
    alert("Error: " + err);
};

function myFunction(data) {
	
	if(rowCount<11){
		var table = document.getElementById("tableID");
	    var row = table.insertRow(rowCount);
	    var cell1 = row.insertCell(0);
	    var cell2 = row.insertCell(1);
	    var cell3 = row.insertCell(2);
	    cell1.innerHTML = data.Temperature;
	    cell2.innerHTML = data.Humidity;
	    cell3.innerHTML = data.timeStamp;
	}else{
		rowCount = rowCount - 1;
		console.log("Count : "+rowCount);
		document.getElementById("tableID").deleteRow(1);
		var table = document.getElementById("tableID");
	    var row = table.insertRow(rowCount);
	    var cell1 = row.insertCell(0);
	    var cell2 = row.insertCell(1);
	    var cell3 = row.insertCell(2);
	    cell1.innerHTML = data.Temperature;
	    cell2.innerHTML = data.Humidity;
	    cell3.innerHTML = data.timeStamp;
	}
    
    
    rowCount++;
}