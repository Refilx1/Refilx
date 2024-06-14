package Atividade_10;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static final String ARQUIVO_ORIGEM = "Atividade_10\\images\\many-flowers.jpg"; // Caminho da imagem de origem
    public static final String ARQUIVO_DESTINO = "Atividade_10\\images\\many-flowers.jpg"; // Caminho da imagem de destino

    public static void main(String[] args) throws IOException {
        BufferedImage ImagemOriginal = ImageIO.read(new File(ARQUIVO_ORIGEM));
        BufferedImage ImagemResultado = new BufferedImage(ImagemOriginal.getWidth(), ImagemOriginal.getHeight(), BufferedImage.TYPE_INT_RGB);

        long startTime = System.currentTimeMillis(); // Medição do tempo inicial
        
        // recolorirUmaThread(ImagemOriginal, ImagemResultado); // Descomente para testar com uma thread
        
        int numberOfThreads = 1; // Defina o número de threads desejado
        recolorMultithreaded(ImagemOriginal, ImagemResultado, numberOfThreads); // Processamento multi-threaded
        
        // recolorFracionado(ImagemOriginal, ImagemResultado, numberOfThreads); // Descomente para testar processamento fracionado

        long endTime = System.currentTimeMillis(); // Medição do tempo final
        
        long duration = endTime - startTime; // Cálculo da duração
        
        File outputFile = new File(ARQUIVO_DESTINO); // Salva a imagem resultante
        ImageIO.write(ImagemResultado, "jpg", outputFile);
        
        System.out.println(String.valueOf(duration)); // Exibe a duração do processamento
    }

    public static void recolorFracionado(BufferedImage ImagemOriginal, BufferedImage ImagemResultado, int partes) {
        int width = ImagemOriginal.getWidth();
        int height = ImagemOriginal.getHeight() / partes;
        
        for (int i = 0; i < partes; i++) {
            final int multiplicadorInicio = i;
            int xInicio = 0;
            int yInicio = height * multiplicadorInicio;
            
            recolorirImagem(ImagemOriginal, ImagemResultado, xInicio, yInicio, width, height);
        }
    }
    
    public static void recolorMultithreaded(BufferedImage ImagemOriginal, BufferedImage ImagemResultado, int numberOfThreads) {
        List<Thread> threads = new ArrayList<>();
        int width = ImagemOriginal.getWidth();
        int height = ImagemOriginal.getHeight() / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadMultiplier = i;

            Thread thread = new Thread(() -> {
                int xOrigin = 0;
                int yOrigin = height * threadMultiplier;

                recolorirImagem(ImagemOriginal, ImagemResultado, xOrigin, yOrigin, width, height);
            });

            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void recolorirUmaThread(BufferedImage ImagemOriginal, BufferedImage ImagemResultado) {
        recolorirImagem(ImagemOriginal, ImagemResultado, 0, 0, ImagemOriginal.getWidth(), ImagemOriginal.getHeight());
    }

    public static void recolorirImagem(BufferedImage ImagemOriginal, BufferedImage ImagemResultado, int leftCorner, int topCorner, int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < ImagemOriginal.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < ImagemOriginal.getHeight(); y++) {
                recolorirPixel(ImagemOriginal, ImagemResultado, x, y);
            }
        }
    }

    public static void recolorirPixel(BufferedImage ImagemOriginal, BufferedImage ImagemResultado, int x, int y) {
        int rgb = ImagemOriginal.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;

        if (ehNivelDeCinza(red, green, blue)) {
            newRed = Math.min(255, red + 100);
            newGreen = Math.max(0, green - 20);
            newBlue = Math.max(0, blue - 120);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRGB = createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(ImagemResultado, x, y, newRGB);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    public static boolean ehNivelDeCinza(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGBFromColors(int red, int green, int blue) {
        int rgb = 0;
        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;
        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }
}
