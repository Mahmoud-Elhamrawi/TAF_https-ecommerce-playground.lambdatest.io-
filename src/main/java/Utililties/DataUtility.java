package Utililties;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {

    //TODO::Read Data From Json File
     private static final String FilesPath = "src/test/resources/TestData/";
    public static String readJsonFile(String fileName , String key)  {
        try {
            FileReader reader = new FileReader(FilesPath+fileName+".json");
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(key).getAsString();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

return "";
    }

    //TODO::Read Data From Property File
    public static String readPropertyFile(String fileName , String property) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(FilesPath+fileName+".properties"));
            return properties.getProperty(property);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
     return "";
    }


}
