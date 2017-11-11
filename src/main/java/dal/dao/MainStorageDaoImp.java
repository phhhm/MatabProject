package dal.dao;

import dal.entities.MainStorageEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MainStorageDaoImp extends AbstractDaoImp<MainStorageEntity> implements MainStorageDao {
}
