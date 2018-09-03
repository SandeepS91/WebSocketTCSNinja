package com.tcs.ninja;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public final class EventSocketClient {
	
	public EventSocketClient(URI endpointURI) {
		try {
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		container.connectToServer(this, endpointURI);
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		}
		 
		Session userSession = null;
		 
		@OnOpen
		public void onOpen(Session userSession) {
		System.out.println("client: opening websocket ");
		this.userSession = userSession;
		}
		
		@OnClose
		public void onClose(Session userSession, CloseReason reason) {
		System.out.println("client: closing websocket");
		this.userSession = null;
		}
		 
		@OnMessage
		public void onMessage(String message) {
		System.out.println("client: received message "+message);
		}

}