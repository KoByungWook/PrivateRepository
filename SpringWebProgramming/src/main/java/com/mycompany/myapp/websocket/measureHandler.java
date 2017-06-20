package com.mycompany.myapp.websocket;

import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class measureHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(measureHandler.class);
	
	private List<WebSocketSession> list = new Vector<> ();
 	
	@PostConstruct
	public void init() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				int count = 0;
				while(true) {
					try { 
						for(WebSocketSession session : list) {
							session.sendMessage(new TextMessage(String.valueOf(++count)));
						}
						Thread.sleep(1000); 
					} catch(Exception e) {}
				}
			}
		};
		thread.start();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		LOGGER.info(session.getId());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		LOGGER.info("");
		String strMessage = message.getPayload();
		TextMessage txtMessage = new TextMessage(strMessage); 
		session.sendMessage(txtMessage);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOGGER.info(session.getId());
		list.remove(session);
	}
}
