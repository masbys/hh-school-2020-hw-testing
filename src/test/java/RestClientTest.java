import org.junit.Test;

import javax.xml.ws.Response;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RestClientTest {

    private RestClient restClient = new RestClient();

    @Test
    public void javaResponseNotEmpty() {
        assertTrue(restClient.makeRequest("", Token.VALUE).length() > 0);
    }

    @Test
    public void checkAnywhereInDocument() {
        String string = restClient.makeRequest("Medical" + "Manager", Token.VALUE);
        String regex = ".*Medical .+Manager.*";
        assertTrue(Pattern.matches(regex,string));
    }

    @Test
    public void checkCamouflageSymbol() {
        String string = restClient.makeRequest("pro*", Token.VALUE);
        String regex = ".*[pP][rR][oO].*";
        assertTrue(Pattern.matches(regex,string));
    }

    @Test
    public void checkSynonym() {
        String string = restClient.makeRequest("pr-manager", Token.VALUE);
        String regex = ".*[pP][rR]-мене.*";
        assertTrue(Pattern.matches(regex,string));
    }

    @Test
    public void checkNOT() {
        String string = restClient.makeRequest("pepsi"+ "NOT" + "cola", Token.VALUE);
        String regex = ".*[pP][rR]-мене.*";
        assertTrue(Pattern.matches(regex,string));
    }
}