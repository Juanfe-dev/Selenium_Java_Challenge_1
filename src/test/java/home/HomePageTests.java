package home;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageTests extends BaseTest {

    @Test
    public void testTypeTripOrigin() throws InterruptedException {

        //Lleno campo de Origen y cierra PopUp (si esta visible)
        homePage.waitInSeconds(10, 1);
        homePage.clickXBtnPopUp();
        homePage.clickOnAcceptCookies();
        homePage.waitInSeconds(10, 1);
        homePage.clickOnTripOrigin();
        homePage.waitLoader();
        homePage.clickTripPlaceOrigin();
        homePage.waitInSeconds(10, 1);
        //Lleno campo de Destino
        //homePage.clickOnTripDestiny();
        homePage.clickTripPlaceDestiny();
        //Seleccionar fecha
        homePage.waitLoader();
        homePage.selectInicialDate();
        homePage.selectFinalDate();

        //Seleccionar pasajeros
        homePage.clickOnPassengers();
        for(int i = 0; i < 3; i++){
            homePage.clickAdultBtn();
            homePage.clickChildrenBtn();
            homePage.clickInfantBtn();
        }
        homePage.clickClosePassengerBox();
        homePage.clickSearchBtn();
    }
}
