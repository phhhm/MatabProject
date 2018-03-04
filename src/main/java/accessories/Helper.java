package accessories;

import com.sun.org.apache.regexp.internal.RE;
import dal.entities.ContractEntity;
import dal.entities.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;


public class Helper {
//    @PersistenceContext(name = "matabPUN")
//    protected EntityManager em;

    public static int messageCount = 3;

//    public Response findForeignKeyEntity(String tableName, String fieldName, String fieldAmount) {
//        try {
//            String query = String.format("SELECT table FROM %s table WHERE table.:field = :fieldAmount", tableName);
//            Query jpaQuery = em.createQuery(query);
//            jpaQuery.setParameter("field", fieldName);
//            jpaQuery.setParameter("fieldAmount", fieldAmount);
//            E result = (E) jpaQuery.getSingleResult();
//            System.out.println("good");
//            return Response.status(Response.Status.OK).entity(result).build();
//        }catch (Exception e){
//            System.out.println("bad");
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }

}
