package dal.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 26/10/2017.
 */
public interface DaoInterface<E> {
    List<E> getAll() throws SQLException;
    E getById(Long id) throws  SQLException;
    void Add(E obj) throws SQLException;
    void edit(E obj) throws SQLException;
    void removeById(Long id) throws SQLException;
    void removeAll() throws SQLException;
}
