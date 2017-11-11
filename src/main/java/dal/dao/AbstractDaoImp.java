package dal.dao;

import biz.dto.GiftDto;
import dal.entities.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by parham on 26/10/2017.
 */

public class AbstractDaoImp<E> implements DaoInterface<E> {

    @PersistenceContext(name = "matabPUN")
    protected EntityManager em;

    public static Map<Class,Class> daoToEntityMap = new HashMap<Class, Class>();

    static {
        daoToEntityMap.put(EmployeeDaoImp.class, EmployeeEntity.class);
        daoToEntityMap.put(ContractDaoImp.class, ContractEntity.class);
        daoToEntityMap.put(DismissDaoImp.class, DismissEntity.class);
        daoToEntityMap.put(GiftDaoImp.class, GiftEntity.class);
        daoToEntityMap.put(PaymentDaoImp.class, PaymentEntity.class);
        daoToEntityMap.put(PresentTimeDaoImp.class, PresentTimeEntity.class);
        daoToEntityMap.put(TransactionDaoImp.class, TransactionEntity.class);
        daoToEntityMap.put(CostDaoImp.class, CostEntity.class);
        daoToEntityMap.put(MainStorageDaoImp.class, TransactionEntity.class);
        daoToEntityMap.put(PartialStorageDaoImp.class, PartialStorageEntity.class);
        daoToEntityMap.put(PurchaseSourceDaoImp.class, PurchaseSourceEntity.class);
        daoToEntityMap.put(PatientDaoImp.class, PatientEntity.class);
        daoToEntityMap.put(PrescriptionDaoImp.class, PrescriptionEntity.class);
        daoToEntityMap.put(PrescriptionDrugDaoImp.class, PrescriptionDrugEntity.class);
        daoToEntityMap.put(FileDaoImp.class, FileEntity.class);
        daoToEntityMap.put(DrugDaoImp.class, DrugEntity.class);
        daoToEntityMap.put(DrugDeliveryDaoImp.class, DrugDeliveryEntity.class);
        daoToEntityMap.put(VisitDaoImp.class, VisitEntity.class);
    }

    protected String getEntityClassName() {
        if (!daoToEntityMap.containsKey(this.getClass().getSuperclass())) {
            throw new RuntimeException("dao class not found in map : " + this.getClass().getSuperclass());
        }
        return daoToEntityMap.get(this.getClass().getSuperclass()).getName();
    }

    public List<E> getAll() throws SQLException {
        try {
            String query = String.format("Select e from %s e ", getEntityClassName());
            Query jpaQuery = em.createQuery(query);
            List<E> resultList = jpaQuery.getResultList();
            return resultList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public E getById(Long id) throws SQLException {
        try {
            String query = String.format("SELECT table FROM %s table WHERE table.id = :id", getEntityClassName());
            Query jpaQuery = em.createQuery(query);
            jpaQuery.setParameter("id", id);
            E result = (E) jpaQuery.getSingleResult();
            System.out.println(">>>>>>>>>>>result " + result);
            return result;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public void Add(E obj) throws SQLException {
            em.persist(obj);
    }

    public void edit(E obj) throws SQLException {
        em.flush();
        em.merge(obj);
    }

    public void removeById(Long id) throws SQLException {
        String query = String.format("DELETE FROM %s table WHERE table.id= :id", getEntityClassName());
        Query jpaQuery = em.createQuery(query);
        jpaQuery.setParameter("id", id).executeUpdate();
    }

    public void removeAll() throws SQLException {
        List<E> objectList = getAll();
        for (E object : objectList) {
            em.remove(object);
        }
    }

    public void remove(E obj) throws SQLException {
        em.remove(obj);
    }
}
