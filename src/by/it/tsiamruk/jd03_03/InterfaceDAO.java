package by.it.tsiamruk.jd03_03;

import java.util.List;

/**
 * Created by waldemar on 30/10/2016.
 */
public interface InterfaceDAO<TYPE> {
    TYPE read(int id);

    boolean create(TYPE bean);
    boolean update(TYPE bean);
    boolean delete(TYPE bean);

    List<TYPE> getAll(String wherefrom);
}
