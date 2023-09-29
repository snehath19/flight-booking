package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BookingPageElements extends Driver {


    public BookingPageElements()
    {

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "didomi-notice-disagree-button")
    public  WebElement cookieRejectBtn;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/label/div/div[1]/span")
    public  WebElement sourceTextbox;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div/input")
    public  WebElement sourceDataSelection;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div/ul/li")
    public  WebElement destinationTextbox;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/input")
    public  WebElement destinationDataSelection;
    @FindBy(css = "input[class='odf-input-m odf-text-lg odf-input odf-input-inline odf-clickable odf-text-ellipsis']")
    public  WebElement departureCalenderClick;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/div/div[3]/div/div[2]/div[6]/div[6]")
    public  WebElement departureDateSelection;
    @FindBy(css = "button[class='odf-btn odf-btn-primary']")
    public  WebElement calenderDoneButton;
    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div[1]/div/div[2]/div[1]/div[3]/div[2]/button")
    public  WebElement searchFlight;
    @FindBy(xpath = "//*[@id=\"sorting-tab-cheapest\"]/div")
    public WebElement cheapestButton;
    @FindBy(xpath = "//*[@id=\"sorting-tab-fastest\"]/div")
    public WebElement speedButton;
    @FindBy(css = "span[class='css-bgfepo-Label e15ynz7n0']")
    public WebElement stopCheckbox;
    @FindBy(css = "button[class='prisma-btn prisma-btn-round prisma-btn-default odf-display-inline-block details_change_pax_button']")
    public WebElement addAnotherAdultElement;

    @FindBy(xpath = "//div[@class='aircraftmap_seat odf-icon od-aircraftmap-icon odf-text-xl  aircraftmap_default_seat od-aircraftmap-default-seat-primary']")
    public List<WebElement> availableSeat;

    @FindBy(xpath = "//div[@class='aircraftmap_seat odf-icon od-aircraftmap-icon odf-text-xl  aircraftmap_default_seat od-aircraftmap-default-seat-primary']")
    public WebElement singleSeatElement;
    @FindBy(xpath = "//*[@id=\"passengers0\"]/div[2]/div[2]/div/form/div[1]/div[5]/div[1]/div/div/div[2]/input")
    public WebElement name;//*[@id=\"passengers0\"]/div[2]/div[2]/div/form/div[1]/div[5]/div[1]/div/div/div[2]/input
    @FindBy(xpath = "//*[@id=\"passengers0\"]/div[2]/div[2]/div/form/div[1]/div[5]/div[2]/div/div/div[2]/input")
    public WebElement surName;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/input")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public WebElement conformEmail;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/input")
    public WebElement phone;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[3]/div[1]/div/div/div[2]/input")
    public WebElement address;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[3]/div[2]/div/div/div[2]/input")
    public WebElement postcode;
    @FindBy(xpath = "//*[@id=\"buyer\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div[4]/div[1]/div/div/div[2]/input")
    public WebElement city;
    public int totalSeats;

}
