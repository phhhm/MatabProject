package dal.dao;

import dal.entities.DrugDeliveryEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DrugDeliveryDaoImp extends AbstractDaoImp<DrugDeliveryEntity> implements DrugDeliveryDao {
}
