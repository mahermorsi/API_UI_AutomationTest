package Test;
import Logic.*;
import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.net.http.HttpResponse;

import static Utils.ApiResponseParser.getJsonData;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestomateTest {
    private static DriverSetup newDriver = null;

    private static WrapApiResponse<ApiResponse> result = null;
    private ApiCalls apiCalls = null;

    @BeforeEach
    public void setup(){
        newDriver= new DriverSetup();
        newDriver.setupDriver("chrome"); // get from configuration file
        newDriver.navigateToURL("https://testomate-test.web.app/home"); // get from configuration file
        apiCalls=new ApiCalls();
    }

    @Test
    @Order((1))
    public void createRestaurantTest() throws IOException {
        // ARRANGE
        Restaurant newRestaurant = new Restaurant("7","Sammer","5","Ashdod");
        // ACT
        result = apiCalls.createNewRestaurant(newRestaurant.toString());
        result.setData(getJsonData(result.getData()));
        // ASSERT
        assertTrue(result.getData().isSuccess());
    }

    @Disabled
    @Test
    public void resetRestaurantTest() throws IOException {
        result = apiCalls.performReset();
        result.setData(getJsonData(result.getData()));
    }

    @Test
    @Order(2)
    public void updateRestaurantFieldTest() throws InterruptedException, IOException {
        // ARRANGE
        Restaurant restToUpdate = new Restaurant("7","Maher","99","Acre");
        int id = 7;
        // ACT
        HttpResponse result = apiCalls.updateRestaurantField(id, restToUpdate.toString());
        // ASSERT
        assertEquals(200, result.statusCode());
    }

    @Test
    @Order(3)
    public void checkIfUpdatedTest() {
        // ARRANGE
        MainPage mainPage = new MainPage(newDriver.getDriver());
        // ACT
        Restaurant restaurant = mainPage.checkIfRestaurantFieldUpdated(7);
        // ASSERT
        assertEquals("7",restaurant.getId());
        assertEquals("Maher",restaurant.getName());
        assertEquals("Acre",restaurant.getAddress());
    }

    @Disabled
    @Test
    public void deleteRestaurantTest() throws IOException{
        // ARRANGE
        int id = 1;
        // ACT
        result = apiCalls.deleteRestaurant(id);
        result.setData(getJsonData(result.getData()));
        // ASSERT
        assertTrue(result.getData().isSuccess());
    }

    @AfterEach
    public void tearDown(){
        newDriver.closeDriver();
        result = null;
        apiCalls = null;
    }


}
