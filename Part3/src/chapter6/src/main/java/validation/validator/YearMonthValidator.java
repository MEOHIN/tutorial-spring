package validation.validator;

import validation.annotation.YaerMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YaerMonth, String> {

    private String pattern;

    @Override
    public void initialize(YaerMonth constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

//        yyyyMM
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
}
