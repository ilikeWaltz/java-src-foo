package foo.zip;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipFileFoo {

	private static final Logger logger = LoggerFactory.getLogger(ZipFileFoo.class);

	public static void main(String[] args) {

		String zipFilePath = "";

		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(zipFilePath);

			@SuppressWarnings("unchecked")
			Enumeration<ZipEntry> e = (Enumeration<ZipEntry>) zipFile.entries();
			while (e.hasMoreElements()) {

				ZipEntry zipEntry = e.nextElement();
				logger.info("zipEntry.getName(): {}", zipEntry.getName());
				logger.info("zipEntry.getSize(): {}", zipEntry.getSize());
				logger.info("zipEntry.getCompressedSize(): {}", zipEntry.getCompressedSize());

				logger.info("zipEntry.getCrc(): {}", zipEntry.getCrc());

			}
		} catch (IOException ex) {
			logger.error("", ex);
		} finally {
			if (zipFile != null)
				try {
					zipFile.close();
				} catch (IOException e) {
					logger.error("", e);
				}
		}
	}

}
