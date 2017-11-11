package dal.dao;

import dal.entities.FileEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * Created by parham on 10/28/2017.
 */
@ApplicationScoped
@Transactional
public class FileDaoImp extends AbstractDaoImp<FileEntity> implements FileDao {
}
