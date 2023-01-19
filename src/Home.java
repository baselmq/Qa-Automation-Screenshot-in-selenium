import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();

		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		Date currentTime = new Date();

		String myUpdatedate = currentTime.toString();

		String NewDate = myUpdatedate.replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("./ScreenShot_Folder/" + NewDate + ".jpg"));

	}

}
