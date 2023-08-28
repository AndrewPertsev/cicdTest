package by.aston.intensive.aap.model.converter;

import by.aston.intensive.aap.model.OrganizationEntity;
import by.aston.intensive.aap.model.dto.OrganizationDTOEntity;

public interface ConverterDTO<D extends OrganizationDTOEntity, E extends OrganizationEntity> {

    E convertDtoToEntity(D dto);

    D convertEntityToDto(E entity);
}
