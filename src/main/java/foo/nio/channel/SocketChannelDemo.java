package foo.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

	public static void main(String[] args) {

		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socketChannel != null)
				try {
					socketChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
