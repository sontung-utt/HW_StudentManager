package manager;

import model.Classes;
import readwritedata.ReadWriteClass;

import java.util.Collections;
import java.util.List;

public class ClassManager implements IManager<Classes>{

    List<Classes> classList;
    ReadWriteClass readWriteClass = new ReadWriteClass();
    public ClassManager() {
        this.classList = this.readWriteClass.ReadClass();
    }
    @Override
    public void add(Classes classes) {
        classList.add(classes);
        readWriteClass.WriteClass(classList);
    }

    @Override
    public void update(int id, Classes classes) {
        int index = findIndexById(id);
        classList.set(index, classes);
        readWriteClass.WriteClass(classList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        classList.remove(index);
        readWriteClass.WriteClass(classList);
    }

    @Override
    public List<Classes> getAll() {
        this.classList = this.readWriteClass.ReadClass();
        return this.classList;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < classList.size(); i++) {
            if(classList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public Classes findClassById (int id) {
        int index = findIndexById(id);
        return classList.get(index);
    }


    public int getIdClass(int index) {
        List<Classes> classList = getAll();
        Classes classes = classList.get(index);
        return classes.getId();
    }
}
