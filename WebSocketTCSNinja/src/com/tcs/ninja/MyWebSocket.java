package com.tcs.ninja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/endpoint")
public class MyWebSocket {

	public ArrayList<Session> allSessions;
	private static final Set<Session> sessions = new LinkedHashSet<Session>();
    @OnOpen
    public void onOpen(Session session) {
    	GetServerEndPointSession.setSession(session);
        System.out.println("onOpen::" + session.getId());    
        sessions.add(session);
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose:::" +  session.getId());
        sessions.remove(session);
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("onMessage::From=" + session.getId() + " Message=" + message);
        
        try {
            session.getBasicRemote().sendText("Hello Client " + session.getId() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }
    
    
    public static void sendAll(String JsonString) {
        synchronized (sessions) {
            String message = "Hello";
            System.out.println("Json : "+JsonString);
            for (Session session : sessions) {
                if (session.isOpen()) {
                    session.getAsyncRemote().sendText(JsonString);
                }
            }
        }
    }
}