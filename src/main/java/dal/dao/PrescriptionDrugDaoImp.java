package dal.dao;

import dal.entities.PrescriptionDrugEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PrescriptionDrugDaoImp extends AbstractDaoImp<PrescriptionDrugEntity> implements PrescriptionDrugDao {
}
