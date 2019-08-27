package properties;

import org.testng.Reporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties prop;

    public PropertiesReader() {

        prop = new Properties();

        try {
            String env = PunkProperties.env;

            Reporter.log("ENV: " + PunkProperties.env, true);

            String propertiesFilePath = env + ".properties";
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

            prop.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return prop.getProperty("host");
    }

}
