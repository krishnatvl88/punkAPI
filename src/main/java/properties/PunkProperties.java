package properties;

public class PunkProperties {

    public static final String env = null == System.getProperty("env") ? "" : System.getProperty("env").toLowerCase().trim();

}
