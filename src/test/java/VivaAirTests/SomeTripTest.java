package VivaAirTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BookingPage;

import static org.testng.AssertJUnit.*;

        /*
        * This class contains step by step the  execution of the test
        * */
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
        //Selecting first combo
            if(bookingPage.isLowerHigherFilterBtnExisting() == true){
                    bookingPage.clickOnLowerPriceFilter();
                    bookingPage.clickOnLowerPriceItem();
                    bookingPage.clickContinueBuyCombo();
            } else {
                    bookingPage.clickOnLowerPriceItem();
                    bookingPage.clickContinueBuyCombo();
            }
        //Selecting second combo
            //bookingPage.waitBookingPageLoader();
            if(bookingPage.isLowerHigherFilterBtnExisting() == true){
                    bookingPage.clickOnLowerPriceFilter();
                    bookingPage.clickOnLowerPriceItem();
                    bookingPage.clickContinueBuyCombo();
            } else {
                    bookingPage.clickOnLowerPriceItem();
                    bookingPage.clickContinueBuyCombo();
            }
        //Fill out the forms
            bookingPage.waitBookingPageLoader();
            bookingPage.completeAdultForm();
            bookingPage.completeChildrenForm();
            bookingPage.completeInfantForm();
    }
}
