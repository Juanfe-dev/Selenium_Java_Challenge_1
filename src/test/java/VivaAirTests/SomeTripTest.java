package VivaAirTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BookingPage;

import static org.testng.AssertJUnit.*;

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
            homePage.clickTripPlaceOrigin();
        //Selecting Trip Destiny
            homePage.saveDestinyCities();
            homePage.clickTripPlaceDestiny();
        //Selecting Date
            homePage.waitHomePageLoader();
            homePage.clickTripInitialDate();
            homePage.clickTripFinalDate();
        //Selecting passengers
            homePage.clickOnPassengers();
            homePage.clickChildrenBtn();
            homePage.clickInfantBtn();
            homePage.clickClosePassengerBox();
            assertTrue("Trip dates were not available",homePage.getSearchBtnLocator().isEnabled());

        //Booking Page Test
            BookingPage bookingPage = homePage.clickSearchBtn();
            assertEquals(
            "Booking page not available",
            "Recuerda, nuestros mejores precios están aquí, en www.vivaair.com",
                    bookingPage.getBookingPageText());

            if(bookingPage.isLowerHigherFilterBtnExisting() == true){
                    bookingPage.clickOnLowerPriceFilter();
            } else {
                    bookingPage.clickOnLowerPriceItem();
            }
            bookingPage.waitBookingPageLoader();
            bookingPage.clickContinueBuyCombo();
            bookingPage.waitBookingPageLoader();
            if(bookingPage.isLowerHigherFilterBtnExisting() == true){
                    bookingPage.clickOnLowerPriceFilter();
            } else {
                    bookingPage.clickOnLowerPriceItem();
            }
            bookingPage.waitBookingPageLoader();
            bookingPage.clickContinueBuyCombo();
            //bookingPage.waitBookingPageLoader();
    }
}
