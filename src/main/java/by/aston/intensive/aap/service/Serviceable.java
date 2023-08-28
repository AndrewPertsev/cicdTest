package by.aston.intensive.aap.service;

import by.aston.intensive.aap.model.OrganizationEntity;
import by.aston.intensive.aap.model.dto.OrganizationDTOEntity;

import java.util.List;

public interface Serviceable<E extends OrganizationEntity, D extends OrganizationDTOEntity> {

    /**
     * Adds the new entity.
     *
     * @param dto
     * @return void
     */
    void save(D dto);

    /**
     * Find all entities for specified page.
     *
     * @return List of entities
     */
    List<E> findAll();

    /**
     * Find entity by its identifier.
     *
     * @param id
     * @return entity with corresponding id.
     */
    E findById(Long id);

    /**
     * Updates entity.
     *
     * @param dto the entity with new data
     * @param id  the id of updated entity
     */

    void update(D dto, Long id) ;

    /**
     * Delete entity with specified id.
     *
     * @param id the entity id
     */
    void deleteById(Long id);



}