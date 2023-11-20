package use_case.Map;

public class MapInputData {
    final private String countryName;

    public MapInputData(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
