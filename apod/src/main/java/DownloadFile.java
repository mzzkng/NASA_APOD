import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFile {

    public static void download(String fileUrl, String destinationPath) {
        try (ReadableByteChannel rbc = Channels.newChannel(new URL(fileUrl).openStream());
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("✅ Файл успешно скачан: " + destinationPath);

        } catch (IOException e) {
            System.err.println("❌ Ошибка при скачивании: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "https://epic.gsfc.nasa.gov/archive/natural/2025/07/15/png/epic_1b_20250715134039.png";  // Пример файла (100 МБ)
        String path = "/home/alex/downloads/test.png";  // Путь сохранения

        // Создаём папку, если её нет
        File destFile = new File(path);
        destFile.getParentFile().mkdirs();

        download(url, path);
    }
}
