package by.aston.intensive.aap.dao;

import by.aston.intensive.aap.model.OrganizationEntity;

import java.util.List;

/**
 * The base interface in the DAO layer.
 *
 * @param <T>
 */
public interface OrganizationEntityDAO<T extends OrganizationEntity> {

    /**
     * Adds the new entity.
     *
     * @param entity
     */
    void save(T entity);

    /**
     * Finds all entities from the table.
     *
     * @return List of the entities.
     */
    List<T> findAll();


    /**
     * Finds entity by its identifier.
     *
     * @param id entity identifier.
     * @return entity with corresponding id.
     */
    T findById(Long id);

    /**
     * Updates the new entity.
     *
     * @param entity
     * @return
     */
    void update(T entity, Long id) ;

    /**
     * Deletes the  entity by id.
     *
     * @param id
     * @return .
     */
    void deleteById(Long id);
}


