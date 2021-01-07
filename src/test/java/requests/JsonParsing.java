package requests;
 
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonParsing {

public static JsonObject getJsonFromFile (String fileName) throws JsonIOException, JsonSyntaxException, FileNotFoundException{

        // Read from File to String
        JsonObject jsonObject = new JsonObject();
        
			JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader("testData/" + fileName));
            jsonObject = jsonElement.getAsJsonObject();
        
          return jsonObject;
    }

}