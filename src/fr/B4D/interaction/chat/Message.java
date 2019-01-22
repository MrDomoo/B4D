package fr.B4D.interaction.chat;

import java.io.Serializable;

import fr.B4D.dofus.Dofus;
import fr.B4D.modules.B4DChat;

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
	
	public Message(String pseudo, Channel channel, String text) {
		this.pseudo = pseudo;
		this.channel = channel;
		this.text = text;
	}

	  /*************/
	 /** GET SET **/
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
	
	public void send() {
		if (channel == Channel.Private)
			B4DChat.sendChat(B4DChat.getChannelPrefix(channel) + " " + pseudo + " " + text);
		else
			B4DChat.sendChat(B4DChat.getChannelPrefix(channel) + " " + text);
	}
	
	public void send(String text) {
		if(channel != Channel.Information) {
			this.text = text;
			send();
		}
	}
	
	public Message waitForReply(long timeout) {
		Dofus.getChat().addPseudoFilter(pseudo);
		Message message = Dofus.getChat().waitForMessage(timeout);
		Dofus.getChat().addPseudoFilter(null);
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
				return Channel.General;
			case(4):
				return Channel.Team;
			case(9):
			//case(0x39):
				return Channel.Private;
			case(5):
			//case(0x23):
				return Channel.Business;
			case(6):
			//case(0x21):
				return Channel.Recruitment;
			default:
				throw new UnknowChannelException(Byte.toUnsignedInt(data));
		}
	}
}