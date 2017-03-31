package pl.lait.Test;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import pl.lait.PageObjects.MainPage;
import pl.lait.PageObjects.Reservation2Page;
import pl.lait.PageObjects.ReservationPage;
import pl.lait.PageObjects.SignOnPage;
import pl.lait.Setup.Init;

public class ReservationTest extends Init {
	
	protected static WebDriver driver;
	
	
	//@Before
	public void run(){
		driver = getDriver();
	}
	
	//@Test
	public void reservation(){
		MainPage mainPage = new MainPage();
		SignOnPage signOnPage = new SignOnPage();
		ReservationPage reservPage = new ReservationPage();
		Reservation2Page reserv2Page = new Reservation2Page();
		
		mainPage.link_signOn(driver).click();
		signOnPage.loginAs("vik_qwe123", "qwe123", driver);
		reservPage.radio_oneWay(driver);
		reservPage.selectPassengersCount(driver, "1"); // potrzebuje konkretnie wskazanego obiektu
		//reservPage.selectPassengersCount(driver).selectByVisibleText("2"); // zwraca obiekt, ale nie wzraca nic
		reservPage.selectDepartingFrom(driver, "New York");
		reservPage.selectFromMonth(driver, "March");
		reservPage.selectFromDay(driver, "2");
		reservPage.selectToPort(driver, "London");
		reservPage.selectToMonth(driver, "March");
		reservPage.selectToDay(driver, "22");
		reservPage.radioChooseClass_business(driver);
		reservPage.radioChooseClass_economy(driver);
		reservPage.radioChooseClass_first(driver);
		reservPage.selectAirline(driver, "No Preference");
		
		printScr("reservation");
		
		reservPage.buttonFindFlights(driver).click();
		
		printScr("reservation");
		
		//2 strona rezerwacji
		reserv2Page.radio_depart2(driver).click();
		reserv2Page.radio_return2(driver).click();
		
		printScr("reservation2");
		
		reserv2Page.button_continue(driver).click();
		
		printScr("reservation2");
		
		//3 strona rezerwacji
		reserv2Page.fillPassNames("Viktor", "Sv", driver);
		reserv2Page.selectPassMeal(driver).selectByVisibleText("No preference");
		printScr("reservation3");
		reserv2Page.selectCreditCard(driver).selectByVisibleText("Visa");
		reserv2Page.input_creditNumber(driver).sendKeys("12345678");;
		reserv2Page.selectCreditCardExpirationMonth(driver).selectByVisibleText("07");
		reserv2Page.selectCreditCardExpirationYear(driver).selectByVisibleText("2010");
		reserv2Page.fillCreditOwner("Viktor", "owe", "Sv", driver);
		reserv2Page.chcekboxTicketlessTravel(driver).click();
		reserv2Page.inputBillAddress(driver).clear();
		reserv2Page.inputBillAddress(driver).sendKeys("nowy adres billAddr");
		printScr("reservation3");
		reserv2Page.buttonBuyFlights(driver).click();
		printScr("reservation3");
		
	}

}
