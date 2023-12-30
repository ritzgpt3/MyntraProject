package com.MyntraProject.stepdefinitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.MyntraProject.base.Config;
import com.MyntraProject.keywords.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Hooks {
	@Before
	public void setUp() {
		Keyword keyword = new Keyword();
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
	}

	@After
	public void tearDown() {
		Keyword keyword = new Keyword();
		keyword.quiteAllWindows();
	}

	@After
	public void takeScreenShotOnTestFailure(Scenario scenario) throws IOException {
		Keyword keyword = new Keyword();

		try {
			if (scenario.isFailed()) {
				Date date = new Date();
				String screnShotFname = date.toString().replace(" ", "-").replace(":", "-");
				System.out.println(date);
				AShot ashot = new AShot();
				BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
						.takeScreenshot(Keyword.getDriver()).getImage();
				String baseDir = System.getProperty("user.dir");
				ImageIO.write(img, "png",
						new File(baseDir + "/src/main/resources/FaildTestCaseScreenShot/" + screnShotFname + ".png"));

			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		keyword.quiteAllWindows();

	}

}
