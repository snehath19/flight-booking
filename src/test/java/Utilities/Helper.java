package Utilities;

import Pages.HelperPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Helper extends HelperPageElements {

    public static Helper helperClass;
    public static void setUpDriver() {

        if (helperClass == null) {
            drivers();
            helperClass = new Helper();
        }
    }
    public static void tearDown() {

        if (driver != null) {
            driver.quit();
        }
        helperClass = null;
    }

    public static void scrollUpDown(int scrollValue) {
        for (int i = 0; i < scrollValue; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1)", "");
        }
    }
    //Fetch flight data
    public static void fetchData(String cssValue, String heading, int scrollDown, int scrollUp, String status, String selectedStopAirport) {

        scrollUpDown(scrollDown);
        if (emptyFlightElement.size() != 0) {
            System.out.println("No flights available");
        } else
        {
            List<WebElement> flightDetails = driver.findElements(By.cssSelector(cssValue));
            System.out.println(heading);
            System.out.println("**************");
            //System.out.println("**** Flights available ****");
            int i = 0;
            for (WebElement flightsDetails : flightDetails) {
                System.out.println(flightsDetails.getAttribute("innerText"));
                if (selectedStopAirport.equals("No stops") && status.equals("afterSelectingStopFilter")) {
                    if (!flightsDetails.getText().equals("direct")) {
                        i++;
                    }
                }
            }
            if (status.equals("afterSelectingPriceSort")) {
                List<String> obtainedList = flightDetails.stream().map(n -> n.getText()).collect(Collectors.toList());
                List<String> sortedList = obtainedList;
                Collections.sort(sortedList);
                boolean areSorted = obtainedList.equals(sortedList);
                if (areSorted) {
                    System.out.println("Sorted order");
                } else {
                    System.out.println("Not sorted order");
                }
              } else if (status.equals("afterSelectingStopFilter")) {
                if (i == 0) {
                    System.out.println("**** Filter working ****");
                } else {
                    System.out.println("**** Filter Not working ****");
                }
            }
            scrollUpDown(scrollUp);
        }
    }
    public static void selectFlight() throws InterruptedException {
        //Select flight
        Thread.sleep(2000);
        flightSelection.click();
    }
    public static void findNoOfAdults() {
        String totalNoOfAdultsText = totalNoOfAdultsElement.getText();
        adultNumber = Integer.parseInt(totalNoOfAdultsText);
        System.out.println("Number of adults: " + adultNumber);
    }
    public static void typeOfSeat() throws InterruptedException {
        Thread.sleep(3000);
        String selectedSeats = SelectedSeatElement.getText();
        System.out.println("Selected seats :" + selectedSeats);
        Character seatLetter;
        if (adultNumber == 2) {
            String[] seats = selectedSeats.split("[,]", 0);
            for (String seat : seats) {
                seatLetter = seat.charAt(seat.length() - 1);
                asileWindowMiddle(seatLetter, seat);
            }
        } else {
            seatLetter = selectedSeats.charAt(selectedSeats.length() - 1);
            asileWindowMiddle(seatLetter, selectedSeats);
        }
    }
    public static void asileWindowMiddle(Character seatLetter, String seat) {
        if (seatLetter == 'A' || seatLetter == 'F') {
            System.out.println(seat + " :window seat");
        } else if (seatLetter == 'C' || seatLetter == 'D') {
            System.out.println(seat + " :Aisle seat");
        } else if (seatLetter == 'B' || seatLetter == 'E') {
            System.out.println(seat + " :Middle seat");
        }
    }
}