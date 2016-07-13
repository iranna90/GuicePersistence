package persist;

/**
 * Created by iranna on 13-7-16.
 */
public interface PersistApi {

    <T> T saveOrUpdate(T t);
}
