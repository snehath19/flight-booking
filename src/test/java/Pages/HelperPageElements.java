package Pages;


import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HelperPageElements extends Driver
{
    public HelperPageElements()
    {

        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "span[class='css-4ac0ja-BaseText-Text ek4n60o0']")
    public  static List<WebElement> emptyFlightElement;

    @FindBy(xpath = "//button[@class='e6ygnnq0 css-320tze-StyledBaseCallToAction-StyledButton e3hopz80'][1]")
    public  static WebElement flightSelection;
    @FindBy(xpath = "//*[@id=\"passengers_search_manager\"]/div[2]/div/div[1]/div/span/div/span[2]")
    public  static WebElement totalNoOfAdultsElement;
    @FindBy(xpath = "//*[@id=\"seatmap-selection-manager\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/span[2]")
    public  static WebElement SelectedSeatElement;

    public  static String stopData;
    public static int adultNumber;
}