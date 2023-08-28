package by.aston.intensive.aap.service.validation;

public interface Validable <Object>{
    boolean validate(Object o );
    boolean validateDto(Object o );
}
