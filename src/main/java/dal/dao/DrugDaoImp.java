package dal.dao;

import dal.entities.DrugEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DrugDaoImp extends AbstractDaoImp<DrugEntity> implements DrugDao {
}
