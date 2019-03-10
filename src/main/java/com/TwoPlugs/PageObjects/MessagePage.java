package com.TwoPlugs.PageObjects;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MessagePage {
	
	public WebDriver ldriver;
  public MessagePage(WebDriver rdriver)
  {
	  ldriver = rdriver;
	  PageFactory.initElements(rdriver, this);
  }
  int tpagebtns;
  ArrayList<String> BeforeSortList  = new ArrayList<String>();
  ArrayList<String> AfterSortList  = new ArrayList<String>();
  List <WebElement> namel;
  
  
  
  @FindBy(xpath="//*[@id='inbox']/table/tbody/tr")
  List <WebElement> totalNoOfRows;
  
  
  public int getTotalNoOfRowsMessages()
  {
	System.out.println(totalNoOfRows.size());
	  return  totalNoOfRows.size();
	 
  }
  
  
  //pagination bar
  @FindBy(xpath="//ul[@class='pagination clearfix']//ul[@class='pagination clearfix']")
  WebElement paginationBar;
  
  //No of pagination buttons in pagination bar
  @FindBy(xpath="//*[@id='delete_form']/section/div/div/div/div/nav/ul/nav/ul/li")
  WebElement paginationButtons;
  
  //NExt button pagination bar
  @FindBy(xpath="//span[@class='help'][contains(text(),'2')]")
  WebElement nextBtn;
  
  //Last button on pagination bar
  @FindBy(xpath="//*[@id='delete_form']/section/div/div/div/div/nav/ul/nav/ul/li[14]")
  WebElement lastBtn;
  
  @FindBy(xpath="//*[@id='delete_form']/section/div/div/div/div/nav/ul/nav/ul/li")
  List <WebElement> noOfPagebtns;
  public void  getTotalnoOfPageBtns()
  {
	  tpagebtns=noOfPagebtns.size();
	
  }
  
  
  
  
  public void clickNextPage()
  {
	//  WebDriverWait wait = new WebDriverWait(ldriver, 10);
	//  wait.until(ExpectedConditions.visibilityOf(nextBtn));
	  nextBtn.click();
  }
 
  public void clickLastPage()
  {
	  lastBtn.click();
  }
  
  public boolean paginationButtons()
  {
	 if (paginationButtons.isDisplayed())
	    return true;
	 else
		 return false;
  }
  
  public boolean checkLastPagedisplayed()
  {
	  return lastBtn.isDisplayed();
  }
  
  
  //Select box for sortlist
  
  @FindBy(xpath="//*[@id='sort-styler']/div[1]/div[2] ")
  WebElement dropList;
  
  
   @FindBy(xpath="//*[@id='sort-styler']/div[2]/ul/li[2]")
   WebElement dropName;

  
   @FindBy(xpath="//*[@id='sort-styler']/div[2]/ul/li[1]")
   WebElement dropDate;
   
   @FindBy(xpath="//*[@id='inbox']/table/tbody/tr/td[1]/span")
   List<WebElement> names;
   
  @FindBy(xpath="//*[@id='inbox']/table/tbody/tr/td[4]")
  List <WebElement> dates;
   
   public void clickDropList()
   {
	   dropList.click();
   }
   
   public void clickDropName()
   {
	   dropName.click();
   }

   public void clickDropDate()
   {
	   dropDate.click();
   }
   
   public void GetNameBeforesort(String type)
   {
	   if(type.equals("name")) 
		  {
		   namel= names; 
		  }
		  else
		  {
			  namel= dates;
		  }
	//  List <WebElement> namel= names;
	  for(WebElement l: namel)
	  {
	//    System.out.println(l.getText());
		BeforeSortList.add(l.getText());
	  }
	  
	//  System.out.println(BeforeSortList.size());
	
   }
   
   
   public boolean AfterSort(String type)
   {
	 
	  if(type.equals("name")) 
	  {
		 namel= names; 
	  }
	  else
	  {
		   namel= dates;
	  }
	 // List <WebElement> namel= names;
	  for(WebElement after: namel)
	  {
	//  System.out.println(after.getText());
		AfterSortList.add(after.getText());
	  }
	  
	//  System.out.println(AfterSortList.size());
	  return BeforeSortList.equals(AfterSortList);
	  

   }

}
