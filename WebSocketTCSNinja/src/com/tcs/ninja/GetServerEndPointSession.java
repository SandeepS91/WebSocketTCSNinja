package com.tcs.ninja;

import java.util.Set;

import javax.websocket.Session;

public class GetServerEndPointSession {

	private static Session session;
	static Set<Session> allSessions; 

	public static Set<Session> getAllSessions() {
		return allSessions;
	}

	public static void setAllSessions(Set<Session> aSessions) {
		allSessions = aSessions;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		GetServerEndPointSession.session = session;
	}
}