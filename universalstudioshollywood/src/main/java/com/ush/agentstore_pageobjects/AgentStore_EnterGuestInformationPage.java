package com.ush.agentstore_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AgentStore_EnterGuestInformationPage {

	WebDriver localDriver;

	AgentStore_EnterGuestInformationPage(WebDriver remoteDriver) {

		this.localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);

	}

	
	@FindBy(id="AgentTicketStoreContents_GuestInformation_SkillSetDDL")
	@CacheLookup
	private WebElement callTypeDropDown;

	public void callTypeDropDownSelection(String VisibleText) {
		callTypeDropDown.isEnabled();
		Select select = new Select(callTypeDropDown);
		select.selectByVisibleText(VisibleText);
	}

	@FindBy(id="FirstName")
	@CacheLookup
	private WebElement fName;
	public void setFirstName(String fNameValue) {
		if(fName.isEnabled()) {
			fName.clear();
			fName.sendKeys(fNameValue);	
		}
	}

	@FindBy(id="LastName")
	@CacheLookup
	private WebElement lName;
	public void setLastName(String lNameValue) {
		if(lName.isEnabled()) {
			lName.clear();
			lName.sendKeys(lNameValue);
		}
	}

	@FindBy(id="PhoneNumber")
	@CacheLookup
	private WebElement pNumber;
	public void setPhoneNumber(String pNum) {
		if(pNumber.isEnabled())
		{
			lName.clear();
			lName.sendKeys(pNum);	
		}
	}

	@FindBy(id="Email")
	@CacheLookup
	private WebElement eMail;
	public void setEmail(String eMailID) {
		if(eMail.isEnabled())
		{
			eMail.clear();
			eMail.sendKeys(eMailID);
		}
	}


	@FindBy(id="AgentTicketStoreContents_GuestInformation_NumOfAdultsUCBox_NumberEntry")
	@CacheLookup
	private WebElement adultQty;
	public void setAdultQTY(String EnterAdultQty) {
		if(adultQty.isEnabled())
		{
			adultQty.clear();
			adultQty.sendKeys(EnterAdultQty);
		}
	}

	@FindBy(id="AgentTicketStoreContents_GuestInformation_NumOfChildrenUCBox_NumberEntry")
	@CacheLookup
	private WebElement childQty;
	public void setChildQTY(String EnterChildQty) {
		if(childQty.isEnabled())
		{
			childQty.clear();
			childQty.sendKeys(EnterChildQty);
		}
	}

	@FindBy(id="AgentTicketStoreContents_GuestInformation_DateOfFirstVisit")
	@CacheLookup
	private WebElement datePicker;
	public void setDate(String EnterDate) {
		if(datePicker.isEnabled())
		{
			datePicker.clear();
			datePicker.sendKeys(EnterDate);
		}
	}

	@FindBy(id="AgentTicketStoreContents_GuestInformation_DaysVisitingUCBox_NumberEntry")
	@CacheLookup
	private WebElement daysVisit;
	public void setNumberOfDaysVisit(String EnterNumberOfDaysVisit) {
		if(daysVisit.isEnabled())
		{
			daysVisit.clear();
			daysVisit.sendKeys(EnterNumberOfDaysVisit);
		}
	}

	@FindBy(id="AgentTicketStoreContents_GuestInformation_VisitedBeforeYes")
	@CacheLookup
	private WebElement visitedBeforeRadioYes;
	public void setVisitedBeforeRadioButtonYes() {
		if(visitedBeforeRadioYes.isEnabled())
		{
			visitedBeforeRadioYes.click();
		}
	}


	@FindBy(id="AgentTicketStoreContents_GuestInformation_VisitedBeforeNo")
	@CacheLookup
	private WebElement visitedBeforeRadioNo;
	public void setVisitedBeforeRadioButtonNo() {
		if(visitedBeforeRadioNo.isEnabled())
		{
			visitedBeforeRadioNo.click();
		}
	}

	@FindBy(id="AgentTicketStoreContents_GuestInformation_visitingFrom")
	@CacheLookup
	private WebElement visitingFromTextBox;
	public void setVisitingFromTextBox(String EnterVisitingFrom) {
		if(visitingFromTextBox.isEnabled())
		{
			visitingFromTextBox.clear();
			visitingFromTextBox.sendKeys(EnterVisitingFrom);
		}
	}
	@FindBy(id="AgentTicketStoreContents_GuestInformation_FloridaResidentYes")
	@CacheLookup
	private WebElement canadaResidentYes;
	public void setCaliforniaResidentYes() {
		if(canadaResidentYes.isEnabled())
		{
			canadaResidentYes.click();
		}
	}


	@FindBy(id="AgentTicketStoreContents_GuestInformation_FloridaResidentNo")
	@CacheLookup
	private WebElement canadaResidentNo;
	public void setCaliforniaResidentNo() {
		if(canadaResidentNo.isEnabled())
		{
			canadaResidentNo.click();
		}
	}

	

}
