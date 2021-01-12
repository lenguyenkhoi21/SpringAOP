import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CountryValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return Country.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "id","The Id Must Not Be Empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "The Name Must Not Be Empty");
    }
}
