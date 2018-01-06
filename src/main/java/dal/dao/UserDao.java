package dal.dao;

import dal.entities.UserEntity;

import javax.enterprise.context.ApplicationScoped;


public interface UserDao extends DaoInterface<UserEntity>{
    UserEntity getByUsernameAndPassword(String username, String password);

}
