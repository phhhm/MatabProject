package dal.dao;

import dal.entities.GiftEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
@Transactional
public class GiftDaoImp extends AbstractDaoImp<GiftEntity> implements GiftDao{

}
