package Logic;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MainPage extends BasePage {
    private static final By TABLE_TAG = By.xpath("//tbody");
    private WebElement tableElement;


    public MainPage(WebDriver driver) {
        super(driver);
        //this.tableElement = this.driver.findElement(TABLE_TAG);
        this.tableElement= new WebDriverWait(this.driver, 3).until(ExpectedConditions.visibilityOfElementLocated(TABLE_TAG));
    }
    private WebElement findUpdatedRestaurantID(int id){
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        for (WebElement row : rows){
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.get(1).getText().contains(String.valueOf(id))){
                return row;
            }
        }
        return null;

    }
    public Restaurant checkIfRestaurantFieldUpdated(int id){
        WebElement row = findUpdatedRestaurantID(id);
        assert row != null;
        List<WebElement> cols = row.findElements(By.tagName("td"));
        String restID = cols.get(1).getText();
        String restName = cols.get(2).getText();
        String restAddress = cols.get(3).getText();
        String restScore = cols.get(4).getText();
        return new Restaurant(restID,restName,restScore,restAddress);
    }

}