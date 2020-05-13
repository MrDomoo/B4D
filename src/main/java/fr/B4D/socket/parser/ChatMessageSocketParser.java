package fr.B4D.socket.parser;

import java.util.Arrays;

import fr.B4D.bot.B4DException;
import fr.B4D.dofus.Dofus;
import fr.B4D.interaction.chat.Channel;
import fr.B4D.interaction.chat.Message;
import fr.B4D.socket.DofusSocket;
import fr.B4D.socket.DofusSocketIterator;
import fr.B4D.socket.SocketElement;

public class ChatMessageSocketParser extends SocketParser<Message>{
	
	//		| Channel | Message length | Message | 0x5e | Id something | Length something | Something | Something else | Pseudo length | Pseudo | ...
	//		|    1    |        2       |    x    |   1  |       3      |         2        |     x     |        8       |        2      |    x   |
	
	public ChatMessageSocketParser() {
		super();
	}

	public Message parse(DofusSocket dofusSocket) throws B4DException {
		DofusSocketIterator iterator = new DofusSocketIterator(dofusSocket.getPayload());
		
		Channel channel = Channel.fromByte(iterator.getNextByte());
		
		Integer textLenght = iterator.getNextSocketElement(2).asSmallEndian();
		String text = iterator.getNextSocketElement(textLenght).asString();
		
		iterator.skip(4);
		
		Integer lengthSomething = iterator.getNextSocketElement(2).asSmallEndian();
		iterator.skip(lengthSomething);
		iterator.skip(8);
		
		Integer pseudoLenght = iterator.getNextSocketElement(2).asSmallEndian();
		String pseudo = iterator.getNextSocketElement(pseudoLenght).asString();
		
		Message message = new Message(pseudo, channel, text);
		
		System.out.println(message);
		return message;
	}
}