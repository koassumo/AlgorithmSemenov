package lesson4;

public interface IteratorTry {

    void reset();
    Object next();
    Object previous();
    Object getCurrent();
    boolean hasNext();
    boolean hasPrevious();
    void atEnd();
    void insertAfter();
    void insertBefore();
    void deleteCurrent();
}
