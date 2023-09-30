import java.io.*;
import java.net.URL;

public class apiCallTest {

    public static void main(String[] args) throws IOException {

        // IMPORTANT: set environment variable with API_KEY=YOUR_API_KEY_HERE in run configurations
        // and replace YOUR_API_KEY_HERE with your api key (similar to the grade api example from lab)
        String API_KEY = System.getenv("API_KEY");

        URL url = new URL("https://financialmodelingprep.com/api/v3/quote/AAPL,FB?apikey=" + API_KEY);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }
        }
    }


}


