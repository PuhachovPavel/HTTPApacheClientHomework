import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class GetRequest {
    public static void main(String[] args) {

        String link = "https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";

        try (
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(new HttpGet(link))
        ) {
            System.out.println("Headers: ");
            for (Header header: response.getAllHeaders()) {
                System.out.println(header.getName() + " : " + header.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ooops");
        }
    }
}
