package requests;

import dataProvider.ConfigFileReader;
import io.restassured.response.Response;
import managers.FileReaderManager;

public class TestContext {
	public static Response response;
	public static ConfigFileReader configFileReader = FileReaderManager.getInstance().getConfigReader();

}
