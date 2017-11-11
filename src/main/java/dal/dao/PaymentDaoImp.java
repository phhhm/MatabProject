package dal.dao;

import dal.entities.PaymentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
@Transactional
public class PaymentDaoImp extends AbstractDaoImp<PaymentEntity> implements PaymentDao {

}
