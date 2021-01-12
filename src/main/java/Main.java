import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.Validator;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanFactory.class, CountryAspect.class, AppConfig.class);
        annotationConfigApplicationContext.refresh();
        Country country = (Country)  annotationConfigApplicationContext.getBean(Country.class);
        CountryValidator countryValidator = (CountryValidator) annotationConfigApplicationContext.getBean(CountryValidator.class);
        TestBeanValidator testBeanValidator = (TestBeanValidator) annotationConfigApplicationContext.getBean(TestBeanValidator.class);
        country.setId(1);
        country.setName("");
        testBeanValidator.setCountry(country);
        testBeanValidator.setCountryValidator(countryValidator);

        try {
            int a = testBeanValidator.sum();
        } catch (Exception e) {
            //e.printStackTrace();
        }

        System.out.println("End");

    }


}
