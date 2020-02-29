package life.springlearning.prabspringpetclinic.services.map;

import life.springlearning.prabspringpetclinic.model.BaseEntity;

import java.util.*;

//Map based implementation of Crud services
//We'll store all data values for models in a hashmap(datasource) and implement methods
//Similarly, we'll have JDBC and JPA based implementations
public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    //All POJOs will have individual services which will inherit from this class
    protected Map<Long,T> map = new HashMap<>();//data source for each POJO
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findByID(ID id){
        return map.get(id);
    }
    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        } else{
            throw new RuntimeException(("Object cannot be null"));
        }

        return object;
    }
    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }
    void deleteById(ID id){
        map.remove(id);
    }
    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            nextId = 1L;
        }
        return  nextId;
    }
}
