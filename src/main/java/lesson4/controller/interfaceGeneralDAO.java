package lesson4.controller;

public interface interfaceGeneralDAO<T> {

    public void save(T obj);
    public void update(T obj);
    public void delete(T obj);
    public T findById(long id, Class<T> t);
}
