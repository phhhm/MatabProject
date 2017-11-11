package biz;

import biz.dto.CostDto;
import converter.MainConverter;
import dal.dao.CostDaoImp;
import dal.dao.DrugDaoImp;
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
    private CostDaoImp costDaoImp;

    @Inject
    private DrugDaoImp drugDaoImp;

    @Inject
    private CostValidator costValidator;

    @EJB
    private MainConverter converter;

    public List<CostDto> getAll() throws SQLException, ValidationException {
        List<CostDto> costDtoList = converter.getList(costDaoImp.getAll(), CostDto.class);
        List<String> validationResult = costValidator.listDtoValidation(costDtoList);
        if (validationResult.size() == 0)
            return costDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public CostDto getById(Long id) throws SQLException, ValidationException {
        CostDto costDto = (CostDto) converter.getObject(costDaoImp.getById(id), CostDto.class);
        List<String> validationResult = costValidator.dtoValidation(costDto);
        if (validationResult.size()==0)
            return costDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(CostDto costDto) throws  SQLException, ValidationException {
        Long drugId = costDto.getDrugId();
        List<String> validationResult = costValidator.dtoValidation(costDto);
        if (validationResult.size() == 0) {
            costDto.setId(null);
            CostEntity costEntity = (CostEntity) converter.getObject(costDto, CostEntity.class);
            costEntity.setDrugEntity(drugDaoImp.getById(drugId));
            costDaoImp.Add(costEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(CostDto costDto) throws SQLException, ValidationException {
        Long drugId = costDto.getDrugId();
        List<String> validationResult = costValidator.dtoValidation(costDto);
        if (validationResult.size() == 0) {
            CostEntity costEntity = (CostEntity) converter.getObject(costDto, CostEntity.class);
            costEntity.setDrugEntity(drugDaoImp.getById(drugId));
            costDaoImp.edit(costEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        costDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        costDaoImp.removeAll();
    }
}
