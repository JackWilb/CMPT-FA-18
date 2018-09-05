/** 
 * An interface for a bag ADT.
 *
 * A bag is an unordered collection of elements 
 * that may contain duplicates. Implementations of
 * this interface may provide either a finite or
 * infinite capacity.
 *
 * @author Greg Gagne January 2017.
 */

public interface Bag
{
    /** 
     * Adds a new element to the bag.
     */
    public void add(Object element);

    /**
     * Adds an array of elements to the bag.
     */
    public void addAll(Object[] elements);

    /**
     * Determines whether a bag contains a specified element.
     *
     * Returns true if bag contains element, false otherwise.
     */
    public boolean contains(Object element);

    /**
     * Retuns the size (in elements) in the bag.
     */
    public int getSize();


    /**
     * Removes the specified element from the bag.
     */
    public void remove(Object element);
}
