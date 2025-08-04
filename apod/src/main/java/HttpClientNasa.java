import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientNasa {
    public static void main(String[] args) throws Exception {
        // 1. Создаём клиент
        HttpClient client = HttpClient.newHttpClient();
        String TokkenNasa = "vyZYn0bdGe6TVO93pkCFXWvaZgFCFFJME9Yv65EM";
        String urlNasaAPOD = "https://api.nasa.gov/planetaty/apod?api_key=";
        String URL_ = urlNasaAPOD + TokkenNasa;
        // 2. Создаём запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_))
                .GET() // GET — это по умолчанию, можно не указывать
                .build();

        // 3. Отправляем и получаем ответ
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        // 4. Обрабатываем результат
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Headers: " + response.headers().map());
        System.out.println("Body: " + response.body());
        response.toString();
    }
}