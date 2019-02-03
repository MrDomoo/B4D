package fr.B4D.interaction.chat;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import fr.B4D.bot.B4D;
import fr.B4D.dofus.Dofus;
import fr.B4D.program.CancelProgramException;
import fr.B4D.program.StopProgramException;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 5508700695491701427L;

	  /**************/
	 /** ATRIBUTS **/
	/**************/
	
	private String pseudo, text;
	private Channel channel;
	
	  /*************/
	 /** BUILDER **/
	/*************/
	
	public Message(Channel channel, String text) {
		this.channel = channel;
		this.text = text;
	}
	
	public Message(String pseudo, String text) {
		this.pseudo = pseudo;
		this.channel = Channel.PRIVATE;
		this.text = text;
	}
	
	public Message(String pseudo, Channel channel, String text) {
		this.pseudo = pseudo;
		this.channel = channel;
		this.text = text;
	}

	  /*************/
	 /** GETTERS **/
	/*************/
	
	public String getPseudo() {
		return pseudo;
	}
	public String getText() {
		return text;
	}
	public Channel getChannel() {
		return channel;
	}
	
	  /**************/
	 /** METHODES **/
	/**************/
	
	public static void sendChat(String text, int millis) throws StopProgramException, CancelProgramException {
		try {
			B4D.mouse.chatClick();
			B4D.keyboard.writeKeyboard(text, millis);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			B4D.wait.wait(100);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public static void sendChat(String text) throws StopProgramException, CancelProgramException{
		sendChat(text, 500);
	}
	
	public void send() throws StopProgramException, CancelProgramException {
		if (channel == Channel.PRIVATE)
			sendChat(channel.getPrefix() + " " + pseudo + " " + text);
		else
			sendChat(channel.getPrefix() + " " + text);
	}
	
	public void reply(String text) throws StopProgramException, CancelProgramException {
		if(channel == Channel.BUSINESS || channel == Channel.RECRUITMENT)
			channel = Channel.PRIVATE;
		this.text = text;
		send();
	}
	
	public Message waitForReply(long timeout) {
		B4D.logger.debug(this, "Attente d'une r�ponse");
		if(pseudo != null)
			Dofus.chat.addPseudoFilter(pseudo);
		else
			Dofus.chat.addChannelFilter(Channel.PRIVATE);
		
		Message message = Dofus.chat.waitForMessage(timeout);
		
		Dofus.chat.addPseudoFilter(null);
		Dofus.chat.addChannelFilter(null);
		return message;
	}
	
	  /***************/
	 /** TO STRING **/
	/***************/
	
	public String toString() {
		if(pseudo != null)
			return "[" + channel.toString() +"][" + pseudo + "] " + text;
		else
			return "[" + channel.toString() +"] " + text;
	}
	
	  /************/
	 /** STATIC **/
	/************/
	
	public static Channel getChannel(byte data) throws UnknowChannelException {
		switch(Byte.toUnsignedInt(data)) {
			case(0):
				return Channel.GENERAL;
			case(4):
				return Channel.TEAM;
			case(0x09):
				return Channel.PRIVATE;
			case(5):
				return Channel.BUSINESS;
			case(6):
				return Channel.RECRUITMENT;
			default:
				throw new UnknowChannelException(Byte.toUnsignedInt(data));
		}
	}
}
