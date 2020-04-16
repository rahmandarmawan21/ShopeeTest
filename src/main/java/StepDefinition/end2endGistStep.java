package StepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class end2endGistStep {
	public static WebDriver driver;
	/*create public gist*/
	@Given("^open browser and go to gist page \"([^\"]*)\"$")
    public void open_browser_and_go_to_gist_page_something(String strArg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver","..//ShopeeTest//browser//chromedriver.exe");  
		driver = new ChromeDriver();
	    driver.manage().window().maximize();			
	    driver.get(strArg1);
    }

    @When("^user on gist page$")
    public void user_on_gist_page() throws Throwable {
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Then("^user click signin$")
    public void user_click_signin() throws Throwable {
        driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']")).click();
    }

    @Then("^user click button signin$")
    public void user_click_button_signin() throws Throwable {
        driver.findElement(By.xpath("//input[@name='commit']")).click();
    }

    @Then("^user input gist description \"([^\"]*)\"$")
    public void user_input_gist_description_something(String strArg1) throws Throwable {
        driver.findElement(By.name("gist[description]")).sendKeys(strArg1);
    }

    @Then("^user click button create public gist$")
    public void user_click_button_create_public_gist() throws Throwable {
       driver.findElement(By.xpath("//button[contains(text(),'Create public gist')]")).click(); 
    }

    @And("^user input username \"([^\"]*)\"$")
    public void user_input_username_something(String strArg1) throws Throwable {
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(strArg1);
    }

    @And("^user input password \"([^\"]*)\"$")
    public void user_input_password_something(String strArg1) throws Throwable {
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(strArg1);
    }

    @And("^open url \"([^\"]*)\"$")
    public void open_url_something(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^user input filename \"([^\"]*)\"$")
    public void user_input_filename_something(String strArg1) throws Throwable {
    	driver.findElement(By.name("gist[contents][][name]")).sendKeys(strArg1);
    }

    @And("^user input content \"([^\"]*)\"$")
    public void user_input_content_something(String strArg1) throws Throwable {
    	driver.findElement(By.xpath("//pre[contains(@class,'CodeMirror-line')]")).click();
        driver.findElement(By.xpath("//pre[contains(@class,'CodeMirror-line')]")).sendKeys(strArg1);
    }
    
    /*edit public gist*/
    @When("^user click button edit$")
    public void user_click_button_edit() throws Throwable {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id=\"gist-pjax-container\"]/div[1]/div/div[1]/ul/li[1]/a")).click();
        //driver.findElement(By.className("btn btn-sm")).click();
    }

    @Then("^user click button update public gist$")
    public void user_click_button_update_public_gist() throws Throwable {
        driver.findElement(By.className("btn btn-primary")).click();
    }
    /*delete public gist*/
    @When("^user click button delete$")
    public void user_click_button_delete() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"gist-pjax-container\"]/div[1]/div/div[1]/ul/li[2]/form/button")).click();
        //driver.findElement(By.className("btn btn-sm btn-danger")).click();
    }

    @Then("^user click button confirm delete$")
    public void user_click_button_confirm_delete() throws Throwable {
    	driver.switchTo().alert().accept();
    }
    /*list all public gist*/
    @When("^user click icon profile$")
    public void user_click_icon_profile() throws Throwable {
        driver.findElement(By.className("Header-link name")).click();
    }

    @Then("^user click your gist menu$")
    public void user_click_your_gist_menu() throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),'Your gists')]")).click();;
    }
}
