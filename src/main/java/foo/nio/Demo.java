package foo.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo {

	public static void main(String[] args) {

		try {

			RandomAccessFile file = new RandomAccessFile("../nio_note", "rw");
			FileChannel channel = file.getChannel();

			ByteBuffer buffer = ByteBuffer.allocate(128);

			int bytesRead = channel.read(buffer);
			while (bytesRead != -1) {

				System.out.println("Read " + bytesRead);
				buffer.flip();

				while (buffer.hasRemaining()) {
					System.out.print((char) buffer.get());
				}

				buffer.clear();

				bytesRead = channel.read(buffer);

			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}