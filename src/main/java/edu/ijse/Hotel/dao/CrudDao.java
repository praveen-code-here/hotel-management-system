package edu.ijse.lovers_leap.dao;

import java.util.ArrayList;

public interface CrudDao<T,ID,Iid> extends SuperDao{
    boolean add(T t) throws  Exception;
    T get(Iid id) throws Exception;
    T getId(ID id) throws Exception;
    ArrayList<T> getAll() throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(Iid id) throws Exception;
}
