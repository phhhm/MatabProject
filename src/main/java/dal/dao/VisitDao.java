package dal.dao;

import dal.entities.VisitEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public interface VisitDao extends DaoInterface<VisitEntity> {
}
