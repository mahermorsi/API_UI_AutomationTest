package Logic;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import Infrastructure.HttpFacade;
import Infrastructure.HttpMethod;
import Infrastructure.WrapApiResponse;
import org.bouncycastle.jcajce.provider.symmetric.AES;

public class ApiCalls {
    private final String BASE_URL = "https://us-central1-testomate-test.cloudfunctions.net/api/";

    public ApiCalls() {
    }
    public WrapApiResponse createNewRestaurant(String jsonBody) throws IOException {
        String url = BASE_URL + "restaurant";
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,jsonBody);
    }
    public WrapApiResponse performReset() throws IOException{
        String url = BASE_URL + "reset";
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,null);
    }
    public WrapApiResponse deleteRestaurant(int id) throws IOException{
        String url = BASE_URL +"restaurant/" + id;
        return HttpFacade.sendHttpRequest(url,HttpMethod.DELETE,null,null);
    }
    public HttpResponse updateRestaurantField(int id, String jsonBody) throws IOException, InterruptedException {
        String url = BASE_URL + "restaurant/" + id;
        return HttpFacade.patchRequest(url,jsonBody);
    }

}