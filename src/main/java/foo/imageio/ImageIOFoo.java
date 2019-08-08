package foo.imageio;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageIOFoo {

	private static Logger logger = LoggerFactory.getLogger(ImageIOFoo.class);

	String imgPath = "";

	@Test
	public void hasAlpha() {

		try {
			BufferedImage read = ImageIO.read(new File(imgPath));
			System.out.println(read);

			if (read != null) {
				ColorModel colorModel = read.getColorModel();
				System.out.println(colorModel);
				if (colorModel != null) {
					boolean hasAlpha = colorModel.hasAlpha();
					System.out.println(hasAlpha);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void h() {

		boolean hasAlpha = false;
		Image image = new ImageIcon(imgPath).getImage();

		// If buffered image, the color model is readily available
		if (image instanceof BufferedImage) {

			BufferedImage bimage = (BufferedImage) image;

			hasAlpha = bimage.getColorModel().hasAlpha();

		} else {

			// Use a pixel grabber to retrieve the image's color model; grabbing
			// a single pixel is usually sufficient
			PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);

			try {
				pg.grabPixels();
			} catch (InterruptedException e) {
				System.out.println("Could not grab image pixels " + e.getMessage());
			}

			// Get the image's color model
			ColorModel cm = pg.getColorModel();
			hasAlpha = cm.hasAlpha();

		}

		System.out.println("Has Alpha? :" + hasAlpha);

	}

}
