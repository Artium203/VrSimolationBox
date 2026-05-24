package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CubeMapSplitter {
    public static void main(String[] args) throws Exception {

        BufferedImage img = ImageIO.read(
                new File("src/main/resources/Textures/Cubemap_Sky_24-512x512.png")
        );

        int size = 512;

        save(img.getSubimage(0, size, size, size), "west.png");
        save(img.getSubimage(size, size, size, size), "front.png");
        save(img.getSubimage(size * 2, size, size, size), "east.png");
        save(img.getSubimage(size * 3, size, size, size), "back.png");

        save(img.getSubimage(size, 0, size, size), "up.png");
        save(img.getSubimage(size, size * 2, size, size), "down.png");

        System.out.println("Done.");
    }

    private static void save(BufferedImage img, String name) throws Exception {
        ImageIO.write(img, "png",
                new File("src/main/resources/Textures/" + name));
    }
}
