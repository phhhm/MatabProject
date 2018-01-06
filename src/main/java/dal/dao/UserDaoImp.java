package dal.dao;

import dal.entities.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserDaoImp extends AbstractDaoImp<UserEntity> implements UserDao {
    @Override
    public UserEntity getByUsernameAndPassword(String username, String password) {
        try {
            String query = String.format(
                    "SELECT table FROM %s table WHERE table.username = :username and table.password = :password",
                    getEntityClassName()
            );
            Query jpaQuery = em.createQuery(query);
            jpaQuery.setParameter("username", username);
            jpaQuery.setParameter("password", password);
            UserEntity result = (UserEntity) jpaQuery.getSingleResult();
            System.out.println(">>>>>>>>>>>result " + result);
            return result;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
