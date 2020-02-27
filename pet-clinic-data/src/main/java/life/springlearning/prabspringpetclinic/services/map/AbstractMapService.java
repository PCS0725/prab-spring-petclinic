package life.springlearning.prabspringpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Map based implementation of Crud services
//We'll store all data values for models in a hashmap(datasource) and implement methods
//Similarly, we'll have JDBC and JPA based implementations
public abstract class AbstractMapService<T,ID> {
    //All POJOs will have individual services which will inherit from this class
    protected Map<ID,T> map = new HashMap<>();//data source for each POJO
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findByID(ID id){
        return map.get(id);
    }
    T save(ID id, T object){
        map.put(id,object);
        return object;
    }
    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }
    void deleteById(ID id){
        map.remove(id);
    }
}
