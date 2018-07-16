package com.scmaster.chatting;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	private Map<String,WebSocketSession> users = new ConcurrentHashMap<String,WebSocketSession>();
	
	/*
	 * Ŭ���̾�Ʈ�� ����Ǹ�, Ŭ���̾�Ʈ�� ���õ� WebSocketSession�� users �ʿ� �����Ѵ�.
	 * �� users ���� ä�� �޽����� ����� ��ü Ŭ���̾�Ʈ�� ������ �� ���
	 */
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + " �����");
		users.put(session.getId(), session);
	}
	
	/*
	 * Ŭ���̾�Ʈ�� ������ �޽����� users �ʿ� ������ ��ü WebSocketSession�� �ٽ� �����Ѵ�.
	 * Ŭ���̾�Ʈ�� �޽����� �����ϸ� ä�� ������ �����ֵ��� ����.
	 * Ư�� Ŭ���̾�Ʈ�� ä�� �޽����� ������ ������ ��ü Ŭ���̾�Ʈ�� �ٽ� �� �޽����� �޾Ƽ� ȭ�鿡 �����ְ� �ȴ�.
	 */

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId() + "�κ��� �޽��� ���� : " + message.getPayload());
		for(WebSocketSession s : users.values()) {
			s.sendMessage(message);
			System.out.println(s.getId() + "�� �޽��� �߼� : " + message.getPayload());
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println(session.getId() + " �ͼ��� �߻� : " + exception.getMessage());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + " ���� �����");
		users.remove(session.getId());
	}
	
}
