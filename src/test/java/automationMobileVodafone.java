import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class automationMobileVodafone {

    RemoteWebDriver driver;


  @BeforeTest
  public void setUpRealIOSDevice() {

      URL url = null;

      //declaring IOS platform properties
      DesiredCapabilities capabilities = new DesiredCapabilities();

      //specify the automation engine
      capabilities.setCapability("automationName", "XCUITest");

      //name of mobile web browser to automate. Should be an empty string if automating an app instead.
      capabilities.setCapability("browserName", "Safari");

      //specify the name of the platform
      capabilities.setCapability("platformName", "iOS");

      //specify the device version on which tests will be run
      capabilities.setCapability("platformVersion", "11.4.1");

      //unique device identifier of the connected physical device
      capabilities.setCapability("udid", "6717bb09ccf7cb236c5cb33de08a16bda6c7029e");

      //The absolute local path or remote http URL to an .ipa file
      //capabilities.setCapability("app", "/Users/user/Downloads/test.ipa");

      //specify Apple Developer Team ID
      capabilities.setCapability("xcodeOrgId", "75V9T68N7X");

      //string representing a signing certificate. Must be used in conjunction with xcodeOrgId
      capabilities.setCapability("xcodeSigningId", "iPhone Developer");

      //The kind of mobile device or emulator to use
      capabilities.setCapability("deviceName", "Fabio");

      //active the console log
      capabilities.setCapability("showXcodeLog", true);

      try {

          url = new URL("http://127.0.0.1:4723/wd/hub");
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }

      driver = new RemoteWebDriver(url, capabilities);

      //defining timeout
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }

      @Test
      public void testRealIOSDevice() {

        //launch the web page
        driver.get("https://www.vodafone.com.mt");

        //interaction with element
        //driver.findElementByName("").click();

      }


      @AfterTest
      public void quitRealIOSDevice() {

          //close all driver instances
          driver.close();

      }

}





