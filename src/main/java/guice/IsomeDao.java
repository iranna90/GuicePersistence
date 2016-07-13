package guice;

public interface IsomeDao {

    public <T> T find(String id, Class<T> clazz, String field);

    public <T> void save(T entity);
}
