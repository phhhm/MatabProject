package dal.dao;

import dal.entities.CostEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CostDaoImp extends AbstractDaoImp<CostEntity> implements CostDao {
}
