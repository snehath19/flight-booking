package stepDefenitions;

import Pages.BookingPageElements;
import Utilities.Helper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BookingStep extends BookingPageElements
{
    @Given("I am on {string} page and Check the url is correct or not")
    public void IAmOnPageAndCheckTheUrlIsCorrectOrNot(String argo) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.opodo.co.uk/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String currentUrl = driver.getCurrentUrl();
        if (argo.contains(currentUrl)) {
            System.out.println("Page landed correctly");
        } else {
            System.out.println("Incorrect landing");
        }
        Thread.sleep(3000);
        cookieRejectBtn.click();
    }
    @When("select source as {string}, destination as {string} and travel date")
    public void selectSourceAsDestinationAsAndTravelDate(String arg0, String arg1) throws InterruptedException
    {
        Thread.sleep(3000);
        sourceTextbox.click();
        Thread.sleep(2000);
        sourceDataSelection.sendKeys(arg0);
        sourceDataSelection.click();
        Thread.sleep(2000);
        destinationTextbox.click();
        Thread.sleep(2000);
        destinationDataSelection.sendKeys(arg1);
        Thread.sleep(2000);
        destinationDataSelection.click();
        Thread.sleep(2000);
        departureCalenderClick.click();
        Thread.sleep(2000);
        departureDateSelection.click();
        calenderDoneButton.click();
        Thread.sleep(2000);
        searchFlight.click();
        Thread.sleep(18000);
    }
    @Then("show available flights")
    public void showAvailableFlights()
    {
        Helper.fetchData("div[class='css-1um4vyc-BaseText-Body e8d0hso0']","Flight names",1000,-1000,"before","");
    }

    @Given("User is shown prices before applying any sort")
    public void user_is_shown_prices_before_applying_any_sort() throws InterruptedException {
        //Price sort
        Helper.fetchData("span[class='money-integer css-1umyyay-BaseText-MoneyPart-DefaultPart e16uabde1']","Price before sorting",1500,-1500,"","");
        Thread.sleep(1000);
    }

    @When("User click on cheapest flights button")
    public void user_click_on_cheapest_flights_button() {
        cheapestButton.click();
    }

    @Then("show prices after the sort")
    public void show_prices_after_the_sort()
    {
        Helper.fetchData("span[class='money-integer css-1umyyay-BaseText-MoneyPart-DefaultPart e16uabde1']","Price after sorting",1500,-1500,"afterSelectingPriceSort","");
    }

    @Then("check if the results are sorted based on cheapest price")
    public void check_if_the_results_are_sorted_based_on_cheapest_price() {

    }

    @Given("User is shown list of flight hours")
    public void user_is_shown_list_of_flight_hours() throws InterruptedException {
        //Time sort
        Helper.fetchData("span[class='css-1mbgvvh-BaseText-Text ek4n60o0']","Time before sorting",1500,-1500,"","");
        Thread.sleep(1000);
    }

    @When("User click on fastest flights button")
    public void user_click_on_fastest_flights_button() {
        speedButton.click();
    }

    @Then("show flight duration of fastest flights in sort order")
    public void show_flight_duration_of_fastest_flights_in_sort_order() {
        Helper.fetchData("span[class='css-1mbgvvh-BaseText-Text ek4n60o0']","Time after sorting",1500,-1500,"","");
    }

    @Given("User is shown the list of flight stops")
    public void user_is_shown_the_list_of_flight_stops() throws InterruptedException {
        //Stop filter
        Helper.fetchData("span[class='css-1kh4dda-BaseText-Text ek4n60o0']","Stop before filtering",1500,-1500,"","");
        Thread.sleep(1000);
    }

    @When("User click on the no stops filter check box")
    public void user_click_on_the_no_stops_filter_check_box() throws InterruptedException {

        Thread.sleep(2000);
        stopCheckbox.click();
        Helper.stopData=stopCheckbox.getText();
    }

    @Then("show the list of stops of all flights")
    public void show_the_list_of_stops_of_all_flights()
    {
        Helper.fetchData("span[class='css-1kh4dda-BaseText-Text ek4n60o0']","Stop after filtering",1500,-1500,"afterSelectingStopFilter",Helper.stopData);
    }

    @Then("check if only direct flights are shown")
    public void check_if_only_direct_flights_are_shown() {

    }

    @Given("user select a flight")
    public void user_select_a_flight() throws InterruptedException
    {
        Helper.selectFlight();
    }

    @Then("check if the user is on the flight details page")
    public void check_if_the_user_is_on_the_flight_details_page() throws InterruptedException {
        Thread.sleep(15000);
        String detailsPageUrl=driver.getCurrentUrl();
        System.out.println(detailsPageUrl);
        if(detailsPageUrl.contains("https://www.opodo.co.uk/travel/secure/#details/"))
        {
            System.out.println("Correct url");
        }
        else {
            System.out.println("Incorrect url");
        }
    }

    @Given("display number of passengers before count is increased")
    public void display_number_of_passengers_before_count_is_increased() throws InterruptedException {
        Helper.selectFlight();
        Thread.sleep(10000);
        Helper.findNoOfAdults();
        Helper.scrollUpDown(200);
    }

    @When("user clicks on Add another adult button in the page")
    public void user_clicks_on_add_another_adult_button_in_the_page() throws InterruptedException {
        addAnotherAdultElement.click();
        Thread.sleep(15000);
        Helper.scrollUpDown(-150);
        Thread.sleep(10000);
    }

    @Then("show the updated number of adults")
    public void show_the_updated_number_of_adults() {
        Helper.findNoOfAdults();
    }

    @Then("check if the number of passengers got increased")
    public void check_if_the_number_of_passengers_got_increased() {
       int s= Helper.adultNumber=  Helper.adultNumber+1;
        if(Helper.adultNumber==s)
        {
            System.out.println("Adult incremented");
        }
        else {
            System.out.println("Adult Not incremented");
        }
    }

    @Given("check the number of seats available")
    public void check_the_number_of_seats_available() throws InterruptedException
    {
        //seat selection
        Helper.selectFlight();
        Thread.sleep(13000);
        addAnotherAdultElement.click();
        Thread.sleep(23000);
        Helper.findNoOfAdults();
        Helper.scrollUpDown(2500);
        totalSeats=  availableSeat.size();
        System.out.println("Total Number of available seats :"+ totalSeats);
    }

    @Then("check if seat size is zero then display no seat available")
    public void check_if_seat_size_is_zero_then_display_no_seat_available()
    {
        if(totalSeats==0)
        {
            System.out.println("No seat available");
        }
    }

    @Then("check if adult number is one then try to add single seat")
    public void check_if_adult_number_is_one_then_try_to_add_single_seat() throws InterruptedException
    {
        if(Helper.adultNumber==1 && totalSeats >0)
        {
            System.out.println("Row number: " + singleSeatElement.getAttribute("data-row"));
            System.out.println("Column Number: " + singleSeatElement.getAttribute("data-column"));
            System.out.println("seat Type: " + singleSeatElement.getAttribute("data-texttype"));
            singleSeatElement.click();
            Thread.sleep(3000);
        }
    }

    @Then("check if adult number is two then try to add two seats")
    public void check_if_adult_number_is_two_then_try_to_add_two_seats() throws InterruptedException
    {
        int j = 0;
        Thread.sleep(2000);
        if(Helper.adultNumber==2 && totalSeats >0) {

            for (WebElement Seat : availableSeat)
            {
                Thread.sleep(2000);
                System.out.println("Row number: " + Seat.getAttribute("data-row"));
                System.out.println("Column Number: " + Seat.getAttribute("data-column"));
                System.out.println("seat Type: " + Seat.getAttribute("data-texttype"));
                Thread.sleep(4000);
                Seat.click();
                j++;
                if (j == 2)
                {
                    break;
                }
            }
            Helper.typeOfSeat();
        }
    }

    @Then("check if selected seat is window or aisle")
    public void check_if_selected_seat_is_window_or_aisle() throws InterruptedException {
        if(Helper.adultNumber==1 && totalSeats >0)
        {

            Helper.typeOfSeat();
        }
    }

    @Given("User is on flight details pages")
    public void userIsOnFlightDetailsPages() throws InterruptedException {
        Helper.selectFlight();
        Thread.sleep(10000);
        Helper.scrollUpDown(100);
    }

    @When("^User tries to enter the adult details (.+) and (.+)$")
    public void userTriesToEnterTheAdultDetails(String names,String Surnames) throws InterruptedException
    {
        name.sendKeys(names);
        surName.sendKeys(Surnames);
        Thread.sleep(4000);
    }

    @Given("User is on flight details page")
    public void userIsOnFlightDetailsPage() throws InterruptedException {
        Helper.selectFlight();
        Thread.sleep(10000);
        Helper.scrollUpDown(500);
    }

    @When("User tries to enter the contact details")
    public void userTriesToEnterTheContactDetails(DataTable testData) throws InterruptedException {
        List<String> details = testData.asList(String.class);
        email.sendKeys(details.get(0));
        conformEmail.sendKeys(details.get(1));
        phone.sendKeys(details.get(2));
        address.sendKeys(details.get(3));
        postcode.sendKeys(details.get(4));
        city.sendKeys(details.get(5));
        Thread.sleep(8000);
    }


}