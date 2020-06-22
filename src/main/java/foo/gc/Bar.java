package foo.gc;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// -Xms8m -Xmx8m
// -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps
// -XX:+PrintClassHistogram -XX:+PrintClassHistogramBeforeFullGC
// -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime
// -XX:+PrintHeapAtGC -XX:+PrintReferenceGC
public class Bar {

	private static final Logger logger = LoggerFactory.getLogger(Bar.class);

	private static final Character[] ORI_CHAR_SET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9' };

	public static void main(String[] args) {
		List<String> l = new LinkedList<>();
		int charArrLength = ORI_CHAR_SET.length;
		int charLength = 8;
		Random random = new Random();
		for (;;) {
			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < charLength; i++)
				stringBuilder.append(ORI_CHAR_SET[random.nextInt(charArrLength)]);

			l.add(stringBuilder.toString());
		}
	}
}
