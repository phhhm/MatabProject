package dal.dao;

import dal.entities.PartialStorageEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PartialStorageDaoImp extends AbstractDaoImp<PartialStorageEntity> implements PartialStorageDao {
}
