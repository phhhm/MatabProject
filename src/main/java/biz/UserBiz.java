package biz;

import biz.dto.UserDto;
import converter.MainConverter;
import dal.dao.UserDao;
import dal.entities.UserEntity;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserBiz {

    @Inject
    private UserDao userDao;

    @EJB
    private MainConverter<UserEntity> userEntityConverter;

    public Long login(UserDto userDto) {
        UserEntity userEntity = userDao.getByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        if (userEntity == null)
            return null;
        else
            return userEntity.getId();
    }
}
