package testdrivendevelop;

import org.testng.annotations.Test;

import com.utilities.Datadriven.JsonDataProvider;

public class JsonReadTest {

	@Test(dataProvider = "logintest", dataProviderClass = JsonDataProvider.class)
	public void test(String username, String password) {
		
		System.out.println(username +" "+ password);
	}


}