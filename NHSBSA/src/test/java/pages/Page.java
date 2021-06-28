package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;

public class Page {

    private static WebDriver driver = Driver.getDriver();   
	//private static WebDriver driver;
    
    /* Select Wales and click on Next button */
    
    private static String startbutton_id = "next-button";
    private static String selectwales_id = "label-wales";
    private static String nextbutton_id = "next-button";
    
    
    /* Enter DOB and click Next button */
    
    private static String day_id = "dob-day";
    private static String month_id = "dob-month";
    private static String year_id = "dob-year";
    
    /* Partner page */
    
    private static String yesbutton_id = "label-yes";
    
    private static String taxcreditsyes_id = "label-yes";
    
    private static String notyet_xpath = "//*[@id='paidUniversalCredit_fieldset']/label[2]";
    
    private static String nobenifits_css = "#benefits_fieldset > label.block-label.noneOption.selection-button-checkbox";
    
    private static String nobutton_id = "label-no";
    
    private static String nhshelps_css = "#prescription-tick";
    
    private static String nhshelp_css = "#sight-test-tick";
    
    
    public static void getUrl(String url) {
        driver.navigate().to(url);
    }

    public static void Clickonstart(String day,String month, String year) throws InterruptedException{
    	
	    driver.findElement(By.id(startbutton_id)).click();
    	String startpage_title = driver.getTitle();
    	//System.out.println("The start page title is:" +startpage_title);
    	String expectedtitle = "Which country do you live in? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(expectedtitle,startpage_title);
	    
	    
	    /* Select Wales and click on Next button */
	    
	    driver.findElement(By.id(selectwales_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
    	String walespage_title = driver.getTitle();
    	//System.out.println("The walespage title is:" +walespage_title);
    	String walespageexpectedtitle = "What is your date of birth? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(walespageexpectedtitle, walespage_title);
	    
	    /* Enter DOB and click Next button */
	    
	    driver.findElement(By.id(day_id)).sendKeys(day);
	    driver.findElement(By.id(month_id)).sendKeys(month);
	    driver.findElement(By.id(year_id)).sendKeys(year);
	    driver.findElement(By.id(nextbutton_id)).click();
	    String dobpage_title = driver.getTitle();
    	//System.out.println("The dobpage title is:" +dobpage_title);
    	String dobpageexpectedtitle = "Do you live with a partner? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(dobpageexpectedtitle, dobpage_title);
	    
    }
    
    public static void Mycircustances(){
    		
    	/* Partner page */
	    
	    driver.findElement(By.id(yesbutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String partnerpage_title = driver.getTitle();
    	//System.out.println("The partnerpage title is:" +partnerpage_title);
    	String partnerpageexpectedtitle = "Do you or your partner claim any benefits or tax credits? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(partnerpageexpectedtitle, partnerpage_title);
	    
	    /* I select 'Yes' to your partner claim any benefits or tax credits */
	    
	    driver.findElement(By.id(taxcreditsyes_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String partnertaxpage_title = driver.getTitle();
    	//System.out.println("The partnertaxpage title is:" +partnertaxpage_title);
    	String partnertaxpageexpectedtitle = "Do you or your partner get paid Universal Credit? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(partnertaxpageexpectedtitle, partnertaxpage_title);
	    
	    /* I select 'Not yet' to Universal credits */
	    
	    
	    driver.findElement(By.xpath(notyet_xpath)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String partneruniversalpage_title = driver.getTitle();
    	//System.out.println("The partneruniversalpage title is:" +partneruniversalpage_title);
    	String partneruniversalpageexpectedtitle = "While you and your partner are waiting on a Universal Credit decision - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(partneruniversalpageexpectedtitle, partneruniversalpage_title);
	    
	    /* universal credit decision click next*/
	    
	    driver.findElement(By.id(nextbutton_id)).click();
	    String universaldecisionpage_title = driver.getTitle();
    	//System.out.println("The universaldecisionpage title is:" +universaldecisionpage_title);
    	String universaldecisionpageexpectedtitle = "Do you or your partner get any of these benefits? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(universaldecisionpageexpectedtitle, universaldecisionpage_title);
	    
	    
	    /* Do you or your partner get any of these benefits? Select No, we don't get any of these */
	    
	    driver.findElement(By.cssSelector(nobenifits_css)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String benifitspage_title = driver.getTitle();
    	//System.out.println("The benifitspage title is:" +benifitspage_title);
    	String benifitspageexpectedtitle = "Are you pregnant or have you given birth in the last 12 months? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(benifitspageexpectedtitle, benifitspage_title);
	    
	    /* Pregnant select 'No' and next */
	    
	    driver.findElement(By.id(nobutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String pregnantpage_title = driver.getTitle();
    	//System.out.println("The pregnantpage title is:" +pregnantpage_title);
    	String pregnantpageexpectedtitle = "Do you have an injury or illness caused by serving in the armed forces? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(pregnantpageexpectedtitle, pregnantpage_title);
    	
    	/* injury or illness caused by serving in the armed forces? Select 'No' */
	    
	    driver.findElement(By.id(nobutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String armedforcepage_title = driver.getTitle();
    	//System.out.println("The armedforcepage title is:" +armedforcepage_title);
    	String armedforcepageexpectedtitle = "Do you have diabetes? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(armedforcepageexpectedtitle, armedforcepage_title);
	    
	    /* Do you have diabetes? Select 'No' */
	    
	    driver.findElement(By.id(nobutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String diabeticpage_title = driver.getTitle();
    	//System.out.println("The diabeticpage title is:" +diabeticpage_title);
    	String diabeticpageexpectedtitle = "Do you or a family member have glaucoma? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(diabeticpageexpectedtitle, diabeticpage_title);
	    
	    /* Do you or a family member have glaucoma? Select 'No' */
	    
	    driver.findElement(By.id(nobutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String glaucomapage_title = driver.getTitle();
    	//System.out.println("The glaucomapage title is:" +glaucomapage_title);
    	String glaucomapageexpectedtitle = "Do you or your partner live permanently in a care home? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(glaucomapageexpectedtitle, glaucomapage_title);
	    
	    /* Do you or your partner live permanently in a carehome? Select 'No' */
	    	    
	    driver.findElement(By.id(nobutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	  //String carehome_title = driver.getTitle();
	    WebElement w = driver.findElement(By.cssSelector("#content > div.grid-row > div > form > p"));
	    String actual = w.getText();
		//System.out.println("The carehome title is:" +carehome_title);
		String expected = "The property you live in doesn't count.";
	    Assert.assertEquals(expected, actual);
	    
	    
	    
	    /* Do you and your partner have more than £16,000 in savings, investments or property? Select 'yes' */
	    
	        
	    driver.findElement(By.id(yesbutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String savingspage_title = driver.getTitle();
    	//System.out.println("The savingspage title is:" +savingspage_title);
    	String savingspageexpectedtitle = "You get help with health costs - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(savingspageexpectedtitle, savingspage_title);
    	
	    
	    WebElement helpstext = driver.findElement(By.cssSelector(nhshelps_css));
	    
    	if(savingspage_title.equals(savingspageexpectedtitle))
    	{
	    	System.out.println("Scenario 1: You get help with NHS health costs for below services:\nYou'll get free:\n" +helpstext.getText());
	    	
	    }
	    else
	    {
	    	System.out.println("Scenario 1: Sorry!!...You will not get help with NHS health costs");
	    }

    }

    
    public static void Mcircustances(){
		
    	/* Partner page select 'No' to partner*/
	    
	    driver.findElement(By.id(nobutton_id)).click();
	    driver.findElement(By.id(nextbutton_id)).click();
	    String partnerpage_title = driver.getTitle();
    	//System.out.println("The partnerpage title is:" +partnerpage_title);
    	String partnerpageexpectedtitle = "Do you claim any benefits or tax credits? - Check what help you could get to pay for NHS costs - NHSBSA";
	    Assert.assertEquals(partnerpageexpectedtitle, partnerpage_title);
    
    
    /* I select 'Yes' to you claim any benefits or tax credits */
    
    driver.findElement(By.id(taxcreditsyes_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String partnertaxpage_title = driver.getTitle();
	//System.out.println("The partnertaxpage title is:" +partnertaxpage_title);
	String partnertaxpageexpectedtitle = "Do you get paid Universal Credit? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(partnertaxpageexpectedtitle, partnertaxpage_title);
    
    /* I select 'Not yet' to Universal credits */
    
    
    driver.findElement(By.xpath(notyet_xpath)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String partneruniversalpage_title = driver.getTitle();
	//System.out.println("The partneruniversalpage title is:" +partneruniversalpage_title);
	String partneruniversalpageexpectedtitle = "While you're waiting on your Universal Credit decision - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(partneruniversalpageexpectedtitle, partneruniversalpage_title);
    
    /* universal credit decision click next*/
    
    driver.findElement(By.id(nextbutton_id)).click();
    String universaldecisionpage_title = driver.getTitle();
	//System.out.println("The universaldecisionpage title is:" +universaldecisionpage_title);
	String universaldecisionpageexpectedtitle = "Do you get any of these benefits? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(universaldecisionpageexpectedtitle, universaldecisionpage_title);
    
    
    /* Do you get any of these benefits? Select No, we don't get any of these */
    
    driver.findElement(By.cssSelector(nobenifits_css)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String benifitspage_title = driver.getTitle();
	//System.out.println("The benifitspage title is:" +benifitspage_title);
	String benifitspageexpectedtitle = "Are you pregnant or have you given birth in the last 12 months? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(benifitspageexpectedtitle, benifitspage_title);
    
    /* Pregnant select 'No' and next */
    
    driver.findElement(By.id(nobutton_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String pregnantpage_title = driver.getTitle();
	//System.out.println("The pregnantpage title is:" +pregnantpage_title);
	String pregnantpageexpectedtitle = "Do you have an injury or illness caused by serving in the armed forces? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(pregnantpageexpectedtitle, pregnantpage_title);
	
	/* injury or illness caused by serving in the armed forces? Select 'No' */
    
    driver.findElement(By.id(nobutton_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String armedforcepage_title = driver.getTitle();
	//System.out.println("The armedforcepage title is:" +armedforcepage_title);
	String armedforcepageexpectedtitle = "Do you have diabetes? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(armedforcepageexpectedtitle, armedforcepage_title);
    
    /* Do you have diabetes? Select 'No' */
    
    driver.findElement(By.id(nobutton_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String diabeticpage_title = driver.getTitle();
	//System.out.println("The diabeticpage title is:" +diabeticpage_title);
	String diabeticpageexpectedtitle = "Do you or a family member have glaucoma? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(diabeticpageexpectedtitle, diabeticpage_title);
    
    /* Do you or a family member have glaucoma? Select 'yes' */
    
    driver.findElement(By.id(yesbutton_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String glaucomapage_title = driver.getTitle();
	//System.out.println("The glaucomapage title is:" +glaucomapage_title);
	String glaucomapageexpectedtitle = "Do you live permanently in a care home? - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(glaucomapageexpectedtitle, glaucomapage_title);
    
    /* Do you or your partner live permanently in a carehome? Select 'No' */
    	    
    driver.findElement(By.id(nobutton_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    //String carehome_title = driver.getTitle();
    WebElement w = driver.findElement(By.cssSelector("#content > div.grid-row > div > form > p"));
    String actual = w.getText();
	//System.out.println("The carehome title is:" +carehome_title);
	String expected = "The property you live in doesn't count.";
    Assert.assertEquals(expected, actual);
    
    
    /* Do you and your partner have more than £16,000 in savings, investments or property? Select 'No' */
    
        
    driver.findElement(By.id(nobutton_id)).click();
    driver.findElement(By.id(nextbutton_id)).click();
    String savingspage_title = driver.getTitle();
	//System.out.println("The savingspage title is:" +savingspage_title);
	String savingspageexpectedtitle = "You get help with health costs - Check what help you could get to pay for NHS costs - NHSBSA";
    Assert.assertEquals(savingspageexpectedtitle, savingspage_title);
	
    
    WebElement helpstext = driver.findElement(By.cssSelector(nhshelps_css));
    WebElement helpstext1 = driver.findElement(By.cssSelector(nhshelp_css));
    
	if(savingspage_title.equals(savingspageexpectedtitle))
	{
    	System.out.println("Scenario 2: You get help with NHS health costs for below services:\nYou'll get free:\n" +helpstext.getText());
    	System.out.println("Scenario 2: You get help with NHS health costs for below services:\nYou'll get free:\n" +helpstext1.getText());
    	
    }
    else
    {
    	System.out.println("Scenario 2: Sorry!!...You will not get help with NHS health costs");
    }

	}
	       
}
