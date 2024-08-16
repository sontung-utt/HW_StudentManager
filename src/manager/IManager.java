package manager;

import java.util.List;

public interface IManager<E>{
    void add(E e);
    void update(int id, E e);
    void remove(int id);
    List<E> getAll();
    int findIndexById(int id);
}
