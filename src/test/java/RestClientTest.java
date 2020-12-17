import org.junit.Test;

import static org.junit.Assert.*;

public class RestClientTest {

    private RestClient restClient = new RestClient();

    @Test
    public void javaResponseNotEmpty() {
        assertTrue(restClient.makeRequest("java", Token.VALUE).length() > 0);
    }
}