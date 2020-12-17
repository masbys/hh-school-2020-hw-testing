import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


public class RestClient {

    public String makeRequest(String text, String token) {
        return ClientBuilder.newClient()
                .target("https://api.hh.ru/vacancies?text="+text)
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token).get(String.class);
    }

    public static void main(String[] args) {
        final String response = new RestClient().makeRequest("msyql", Token.VALUE);
        System.out.println("response = " + response);
    }
}