package use_case.TopNews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class SUPPORTED_COUNTRIES {

    // remember to update both variables when adding new countries
    private static final Map<String, String> supportedCountries = Map.ofEntries(
            entry("Canada", "ca"),
            entry("United States", "us"),
            entry("Russia", "ru"),
            entry("Australia", "au"),
            entry("Brazil", "br"),
            entry("India", "in"),
            entry("China", "cn")
    );
    private static final List<String> supportedCountriesList = new ArrayList<>(
            Arrays.asList(
                    "Canada",
                    "United States",
                    "Russia",
                    "Australia",
                    "Brazil",
                    "India",
                    "China")
    );
    public static Map<String, String> getSupportedCountries() {
        return supportedCountries;
    }
    public static List<String> getSupportedCountriesList() {
        return supportedCountriesList;
    }
}
