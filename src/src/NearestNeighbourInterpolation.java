package src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NearestNeighbourInterpolation {

    public static void main(String[] args) throws IOException {

        String path = "src/5x5.jpg";
        BufferedImage image = ImageIO.read(new File(path));

        int newWidth = 10;
        int newHeight = 10;

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(newWidth, newHeight, image.getType());

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {

                int nearestI = j * width / newWidth;
                int nearestJ = i * height / newHeight;

                int rgb = image.getRGB(nearestI, nearestJ);
                newImage.setRGB(j, i, rgb);
                System.out.print(nearestJ + "" + nearestI + " ");
            }
            System.out.println();
        }

        String outputImagePath = "new.jpg";
        ImageIO.write(newImage, "jpg", new File(outputImagePath));

        System.out.println("Image resized successfully.");
    }
}
