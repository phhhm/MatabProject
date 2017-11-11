package dal.dao;

import dal.entities.EmployeeEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * Created by parham on 26/10/2017.
 */
@ApplicationScoped
@Transactional
public class EmployeeDaoImp extends AbstractDaoImp<EmployeeEntity> implements EmployeeDao {
}
