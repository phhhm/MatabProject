package dal.dao;

import dal.entities.TransactionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
@Transactional
public class TransactionDaoImp extends AbstractDaoImp<TransactionEntity> implements TransactionDao {

}
