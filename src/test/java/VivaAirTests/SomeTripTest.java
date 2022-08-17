package VivaAirTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BookingPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SomeTripTest extends BaseTest {

    @Test //HomePage Test
    public void testRandomTrip() throws InterruptedException {
        //Accept cookies and  close popup (if it's visible)
            homePage.clickXBtnPopUp();
            homePage.clickOnAcceptCookies();
        //Selecting Trip Origin
            homePage.clickOnTripOrigin();
            homePage.waitHomePageLoader();
                        homePage.saveOriginCities();
                        //homePage.printAllCities();
            homePage.clickTripPlaceOrigin();
        //Selecting Trip Destiny
                        homePage.saveDestinyCities();
                        //homePage.printAllCities();
            homePage.clickTripPlaceDestiny();
        //Selecting Date
            homePage.waitHomePageLoader();
            homePage.selectInicialDate();
            homePage.selectFinalDate();
        //Selecting passengers
            homePage.clickOnPassengers();
            for(int i = 0; i < 3; i++){
                homePage.clickAdultBtn();
                homePage.clickChildrenBtn();
                homePage.clickInfantBtn();
            }
            homePage.clickClosePassengerBox();
            //Booking Page Test
            BookingPage bookingPage = homePage.clickSearchBtn();
            bookingPage.clickSomething();
        ;
    }
}
