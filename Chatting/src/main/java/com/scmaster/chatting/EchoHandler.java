package com.scmaster.chatting;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
 * ������ �������� �̿��ؼ� ������ ���� ����
 * 1. WebSocketHandler �������̽��� ����
 * 2. <websocket:handlers>�� �̿��ؼ� ��ûURL�� ���� 
 * WebSocketHandler ���� ��ü ���
 */
public class EchoHandler extends TextWebSocketHandler {

	//�� ���� Ŭ���̾�Ʈ�� ����Ǹ� ȣ��
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(session.getId()+" ���� ��.");
	}


	// ������ Ŭ���̾�Ʈ�� �����͸� ����
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(session.getId()+" �κ��� [" + message.getPayload()+"] ����");
		// ������ ���۵� �޽����� �ٽ� Ŭ���̾�Ʈ�� ����
		session.sendMessage(new TextMessage("echo : " + message.getPayload()));
	}

	// �� ���� Ŭ���̾�Ʈ�� ������ ����Ǹ� ȣ��
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId()+" ���� ����.");

	}
	
}
  