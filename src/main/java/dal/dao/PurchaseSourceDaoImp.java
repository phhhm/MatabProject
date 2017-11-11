package dal.dao;

import dal.entities.PurchaseSourceEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
@Transactional
public class PurchaseSourceDaoImp extends AbstractDaoImp<PurchaseSourceEntity> implements PurchaseSourceDao {

}
