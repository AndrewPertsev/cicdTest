package by.aston.intensive.aap.dao.impl;

import by.aston.intensive.aap.dao.PositionDao;
import by.aston.intensive.aap.model.Position;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class PositionDaoImpl implements PositionDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void save(Position entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Position> findAll() {
        TypedQuery<Position> query = entityManager.createQuery("SELECT p FROM  Position p", Position.class);
        return query.getResultList();
    }


    @Override
    public Position findById(Long id) {
        return entityManager.find(Position.class, id);

    }

    @Override
    public void update(Position entity, Long id) {
        entity.setPositionId(id);
        entityManager.merge(entity);

    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Position.class, id));

    }
}
