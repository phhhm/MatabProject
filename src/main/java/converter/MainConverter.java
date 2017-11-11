package converter;

import org.modelmapper.ModelMapper;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parham on 26/10/2017.
 */
@Stateless
public class MainConverter<E> {
    public E getObject(Object object, Class<?> clazz){
        if (object == null)
            return null;
        ModelMapper modelMapper = new ModelMapper();
        E newObject  = (E) modelMapper.map(object, clazz);
        return newObject;
    }

    public List<E> getList(List<Object> objectList, Class<?> clazz){
        if (objectList == null || objectList.size() == 0)
            return null;
        List<E> newList = new ArrayList<E>();
        for (Object object : objectList) {
            newList.add(getObject(object,clazz ));
        }
        return newList;
    }
}
