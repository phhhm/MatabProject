package biz;

import biz.dto.CostDto;
import converter.MainConverter;
import dal.dao.CostDao;
import dal.dao.DrugDao;
import dal.entities.CostEntity;
import validation.CostValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class CostBiz {

    @Inject
    private CostDao costDao;

    @Inject
    private DrugDao drugDao;

    @Inject
    private CostValidator costValidator;

    @EJB
    private MainConverter converter;

    public List<CostDto> getAll() throws SQLException, ValidationException {
            List<CostDto> costDtoList = converter.getList(costDao.getAll(), CostDto.class);
        List<String> validationResult = costValidator.listDtoValidation(costDtoList);
        if (validationResult.size() == 0)
            return costDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public CostDto getById(Long id) throws SQLException, ValidationException {
        CostDto costDto = (CostDto) converter.getObject(costDao.getById(id), CostDto.class);
        List<String> validationResult = costValidator.dtoValidation(costDto);
        if (validationResult.size()==0)
            return costDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(CostDto costDto) throws  SQLException, ValidationException {
        List<String> validationResult = costValidator.dtoValidation(costDto);
        if (validationResult.size() == 0) {
            Long drugId = costDto.getDrugId();
            costDto.setId(null);
            CostEntity costEntity = (CostEntity) converter.getObject(costDto, CostEntity.class);
            costEntity.setDrugEntity(drugDao.getById(drugId));
            costDao.Add(costEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(CostDto costDto) throws SQLException, ValidationException {
        List<String> validationResult = costValidator.dtoValidation(costDto);
        if (validationResult.size() == 0) {
            Long drugId = costDto.getDrugId();
            CostEntity costEntity = (CostEntity) converter.getObject(costDto, CostEntity.class);
            costEntity.setDrugEntity(drugDao.getById(drugId));
            costDao.edit(costEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        costDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        costDao.removeAll();
    }
}
