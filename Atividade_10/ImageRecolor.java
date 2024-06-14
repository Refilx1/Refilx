package Atividade_10;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRecolor {
    public static void main(String[] args) throws IOException {
        // Carregar a imagem
        File input = new File("Atividade_10\\images\\many-flowers.jpg");
        BufferedImage image = ImageIO.read(input);

        // Número de threads (pode ajustar conforme necessário)
        int numThreads = 4;
        int width = image.getWidth();
        int height = image.getHeight();
        int partHeight = height / numThreads;

        // Criar e iniciar threads
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                recolorPart(image, 0, threadIndex * partHeight, width, partHeight);
            });
            threads[i].start();
        }

        // Esperar todas as threads terminarem
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Salvar a imagem processada
        File output = new File("Atividade_10\\images\\many-flowers.jpg");
        ImageIO.write(image, "jpg", output);
    }

    // Método para recolorir uma parte da imagem
    private static void recolorPart(BufferedImage image, int startX, int startY, int width, int partHeight) {
        for (int x = startX; x < startX + width; x++) {
            for (int y = startY; y < startY + partHeight; y++) {
                int rgb = image.getRGB(x, y);
                if (isWhite(rgb)) {
                    image.setRGB(x, y, 0xFFFF00); // Amarelo
                }
            }
        }
    }

    // Verifica se um pixel é branco
    private static boolean isWhite(int rgb) {
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        return red > 255 && green > 255 && blue > 255; // Pode ajustar o limiar conforme necessário
    }
}