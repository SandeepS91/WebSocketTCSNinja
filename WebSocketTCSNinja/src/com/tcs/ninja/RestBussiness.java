package com.tcs.ninja;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
//import javax.ws.rs.core.Response;

@Path("Ninja")
public class RestBussiness {

	
	// Rest Method for postman 
	
	@POST
	@Path("EmbededJson")
	@Consumes("application/json")
	public String pingMe(RequestBean bean){
	     
		String responseMessage;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("Time : "+timeStamp);
        
        JSONObject jsonObject = new JSONObject();
        try {
			jsonObject.put("Humidity", bean.getHumidity());
			jsonObject.put("Temperature", bean.getTemperatur());
	        jsonObject.put("timeStamp", timeStamp);
	        
	        String jsonString = jsonObject.toString();

			MyWebSocket.sendAll(jsonString);
			
			responseMessage = "Data sent successfully to server";
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			responseMessage = "Error while sending data to server";
			e.printStackTrace();
		}
        
        return responseMessage;

    }

}