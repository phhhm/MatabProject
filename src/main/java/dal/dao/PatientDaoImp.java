package dal.dao;

import dal.entities.PatientEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * Created by parham on 10/28/2017.
 */
@ApplicationScoped
@Transactional
public class PatientDaoImp extends AbstractDaoImp<PatientEntity> implements PatientDao {
}
