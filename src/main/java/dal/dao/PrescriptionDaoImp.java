package dal.dao;

import dal.entities.PrescriptionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PrescriptionDaoImp extends AbstractDaoImp<PrescriptionEntity> implements PrescriptionDao {
}
