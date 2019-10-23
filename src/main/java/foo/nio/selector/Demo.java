package foo.nio.selector;


import java.io.IOException;
import java.nio.channels.Selector;

public class Demo {

	public static void main(String[] args) {

		try {
			Selector selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
