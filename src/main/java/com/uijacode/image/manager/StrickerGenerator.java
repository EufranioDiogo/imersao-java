package com.uijacode.image.manager;

import com.uijacode.models.Content;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StrickerGenerator {
    private final List<Content> contentList;

    public StrickerGenerator(List<Content> contentList) {
        this.contentList = contentList;
    }

    public void generateStickers() {
        this.contentList.stream().limit(5).forEach(content -> {
            try {
                InputStream inputStream = new URL(content.getImageUrl()).openStream();

                create(inputStream, content.getTitle());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    private void create(InputStream imageStream, String fileName) {
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
