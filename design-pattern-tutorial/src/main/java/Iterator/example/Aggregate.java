package Iterator.example;

/**
 *  The interface to create concrete iterator
 *  When create iterator, we can use FactoryMethod.example.Factory Method pattern
 */
public interface Aggregate  {
    Iterator CreateIterator();
}