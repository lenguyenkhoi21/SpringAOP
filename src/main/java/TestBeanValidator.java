public class TestBeanValidator {
    private Country country;

    private CountryValidator countryValidator;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryValidator getCountryValidator() {
        return countryValidator;
    }

    public void setCountryValidator(CountryValidator countryValidator) {
        this.countryValidator = countryValidator;
    }

    public int sum() {
        return 1 + 5;
    }
}
