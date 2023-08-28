package by.aston.intensive.aap.service.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectValidator implements Validable {

    @Override
    public boolean validate(Object o) {
        return false;
    }

    @Override
    public boolean validateDto(Object o) {
        return false;
    }
}


