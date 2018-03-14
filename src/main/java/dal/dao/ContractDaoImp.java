package dal.dao;

import dal.entities.ContractEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
@Transactional
public class ContractDaoImp extends AbstractDaoImp<ContractEntity> implements ContractDao {


    @Override
    public ContractEntity getByEmployeeId(Long employeeId) {
        try {
            String query = String.format("SELECT table FROM %s table WHERE table.employeeEntity.id = :id", "ContractEntity");
            Query jpaQuery = em.createQuery(query);
            jpaQuery.setParameter("id", employeeId);
            ContractEntity result = (ContractEntity) jpaQuery.getSingleResult();
//            System.out.println(">>>>>>>>>>>result " + result);
            return result;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
