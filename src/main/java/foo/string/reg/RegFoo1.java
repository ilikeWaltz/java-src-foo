package foo.string.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegFoo1 {

	private static final Logger logger = LoggerFactory.getLogger(RegFoo1.class);

	public static void main(String[] args) {
		String s = "abcdefg111hijklmn";
		Pattern pattern = Pattern.compile("[0-9]{3}");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			int groupCount = matcher.groupCount();
			logger.info("groupCount: {}", groupCount);
		}
	}
}
