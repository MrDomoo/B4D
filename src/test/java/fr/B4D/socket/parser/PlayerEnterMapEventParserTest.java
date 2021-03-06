package fr.B4D.socket.parser;

import org.junit.Assert;
import org.junit.Test;

import fr.B4D.bot.B4DException;
import fr.B4D.socket.DofusSocket;
import fr.B4D.socket.SocketType;

@SuppressWarnings("javadoc")
public class PlayerEnterMapEventParserTest {

	@Test
	public void changeMap1() throws B4DException  {
		byte[] socket = {(byte) 0x91, 0x05, 0x57, 0x15, (byte) 0xc0, 0x42, 0x53, (byte) 0xed, 0x53, (byte) 0xc0, 0x34, (byte) 0xc0, 0x00, 0x13, 0x10, 0x00, (byte) 0xc3, 0x04, 0x01, 0x00, 0x05, 0x15, (byte) 0xf8, 0x0f, (byte) 0xc6, 0x08, (byte) 0xf5, 0x1c, (byte) 0xb8, 0x04, 0x00, 0x05, 0x01, (byte) 0xff, (byte) 0xba, 0x50, 0x02, (byte) 0xff, (byte) 0xff, (byte) 0xcc, 0x03, 0x23, (byte) 0xaf, 0x0b, 0x04, (byte) 0xb4, 0x09, (byte) 0x92, 0x05, (byte) 0xd5, 0x17, (byte) 0xd2, 0x00, 0x01, 0x7d, 0x00, 0x00, 0x00, 0x08, 0x53, 0x75, 0x68, 0x61, 0x6c, 0x65, 0x78, 0x65, 0x1b, 0x49, 0x00, 0x08, 0x00, 0x01, 0x00, 0x00, 0x08, 0x39, (byte) 0xda, 0x74, 0x00, 0x00, 0x00, 0x42, 0x53, (byte) 0xed, 0x53, (byte) 0xc0, 0x41, (byte) 0x80, 0x00};
		
		Assert.assertEquals(SocketType.PLAYER_ENTER_MAP_SOCKET, SocketType.fromSocket(socket));
		
		DofusSocket dofusSocket = new DofusSocket(socket);
		SocketParser<?> parser = dofusSocket.getParser();

		Assert.assertEquals(PlayerEnterMapEventParser.class, parser.getClass());
	}
}