package test;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import utils.RCBTeam;

public class ValidatePlayers {
	String fileName = "rcbteam.json";
	RCBTeam rcbTeam;

	public void readJsonFile() {
		String filePath = this.getClass().getClassLoader().getResource(fileName).getPath();
		Gson gson = new Gson();

		try (Reader reader = new FileReader(filePath)) {
			rcbTeam = gson.fromJson(reader, RCBTeam.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		readJsonFile();
	}


	@Test
	public void validationForForeignPlayers() {
		int counter = 0;
		for(int i=0; i<rcbTeam.getPlayer().size(); i++) {
			if(!rcbTeam.getPlayer().get(i).getCountry().equalsIgnoreCase("India"))
				counter++;
		}
		Reporter.log("Total Foreign Players = " + counter);
		assertTrue(counter<=4, "Count of foreign players is greater than 4,");
	}
	
	@Test
	public void validationForWicketKeeper() {
		int counter = 0;
		for(int i=0; i<rcbTeam.getPlayer().size(); i++) {
			if(!rcbTeam.getPlayer().get(i).getRole().equalsIgnoreCase("Wicket-keeper"))
				counter++;
		}
		Reporter.log("Total number of Wicket Keepers = " + counter);
		assertTrue(counter>=1, "No Wicket keepers found,");
	}
}
;