package biz;

import biz.dto.UserDto;
import converter.MainConverter;
import dal.dao.UserDao;
import dal.entities.UserEntity;
import validation.UserValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class UserBiz {

    @Inject
    private UserDao userDao;


    @Inject
    private UserValidator userValidator;

    @EJB
    private MainConverter converter;

    public List<UserDto> getAll() throws SQLException, ValidationException {
        List<UserDto> userDtoList = converter.getList(userDao.getAll(), UserDto.class);
        List<String> validationResult = userValidator.listDtoValidation(userDtoList);
        if (validationResult.size() == 0)
            return userDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public UserDto getById(Long id) throws SQLException, ValidationException {
        UserDto userDto = (UserDto) converter.getObject(userDao.getById(id), UserDto.class);
        List<String> validationResult = userValidator.dtoValidation(userDto);
        if (validationResult.size()==0)
            return userDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(UserDto userDto) throws  SQLException, ValidationException {
        List<String> validationResult = userValidator.dtoValidation(userDto);
        if (validationResult.size() == 0) {
            userDto.setId(null);
            UserEntity userEntity = (UserEntity) converter.getObject(userDto, UserEntity.class);
            userDao.Add(userEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(UserDto userDto) throws SQLException, ValidationException {
        List<String> validationResult = userValidator.dtoValidation(userDto);
        if (validationResult.size() == 0) {
            UserEntity userEntity = (UserEntity) converter.getObject(userDto, UserEntity.class);
            userDao.edit(userEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        userDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        userDao.removeAll();
    }

    public Long login(UserDto userDto) {
        UserEntity userEntity = userDao.getByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        if (userEntity == null)
            return null;
        else
            return userEntity.getId();
    }
}
