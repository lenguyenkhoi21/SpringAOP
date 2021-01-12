import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

@Aspect
public class CountryAspect {

    @Autowired
    ApplicationContext applicationContext;

    @Pointcut("execution(public int TestBeanValidator.sum())")
    public void stuff() {

    }

    @Before("stuff()")
    public void doStuffBefore(JoinPoint jp) throws abc{
        System.out.println("Hello Before Stuff");
        TestBeanValidator testBeanValidator = (TestBeanValidator) applicationContext.getBean(TestBeanValidator.class);
        testBeanValidator.getCountryValidator();
        DataBinder dataBinder = new DataBinder(testBeanValidator.getCountry());
        dataBinder.addValidators(testBeanValidator.getCountryValidator());
        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        if (bindingResult.hasErrors()) {
            throw new abc(bindingResult.toString());
        }
        System.out.println("End Before Stuff");
    }
}
