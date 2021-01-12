import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public Country getCountry() {
        return new Country();
    }

    @Bean
    public CountryValidator getCountryValidator() {
        return new CountryValidator();
    }

    @Bean
    TestBeanValidator getTestBean() {
        return new TestBeanValidator();
    }

}
