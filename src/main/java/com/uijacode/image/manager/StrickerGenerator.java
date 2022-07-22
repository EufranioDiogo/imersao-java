package com.uijacode.image.manager;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StrickerGenerator {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new URL("https://imdb-api.com/images/original/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();
        InputStream fileInputStream = new FileInputStream(Paths.get("").toFile());

        create(inputStream, "didks");
    }

    public static void create(InputStream imageStream, String fileName) {
        try {
            BufferedImage originalImage = ImageIO.read(imageStream);


            // cria uma nova imagem
            int originalImageWidth = originalImage.getWidth();
            int originalImageHeight = originalImage.getHeight();
            int newImageHeight = originalImageHeight + 200;

            BufferedImage newImage = new BufferedImage(originalImageWidth, newImageHeight, BufferedImage.TRANSLUCENT);

            Graphics2D graphics = (Graphics2D) newImage.getGraphics();

            graphics.drawImage(originalImage, 0, 0, originalImageWidth, originalImageHeight, null);

            Font font = new Font(Font.SERIF, Font.BOLD, 64);
            graphics.setColor(Color.YELLOW);
            graphics.setFont(font);


            graphics.drawString(fileName, 0, originalImageHeight + 10);


            Path newImagePath = Paths.get("imagens/"+fileName+".png");


            ImageIO.write(newImage, "png", newImagePath.toFile());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
