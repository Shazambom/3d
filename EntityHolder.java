import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.SortedSet;

/**
 * Acts as a Functional Sorted Set. Will be helpful to hold and sort entities
 * generated within game. Remember ALL entities are added to this Set.
 *
 * @author Ian Moreno
 * @version 2.0
 * @param <E> A comparable object that is contained within this sorted set.
 */
public class EntityHolder<E extends Comparable<? super E>>
    implements SortedSet<E> {

    private ArrayList<E> list;
    private Comparator<E> c;

    /**
     * Creates a EntityHolder using the Comparable's compareTo as Comparator
     */
    public EntityHolder() {
        this.c = new Comparator<E>() {
            public int compare(E obj1, E obj2) {
                return ((Entity) obj1).getNumEntity()
                    - ((Entity) obj2).getNumEntity();
            }
        };

        //((int a, int b) -> { return a - b; });
        list = new ArrayList<E>();
    }

    /**
     * Creates a EntityHolder using a specific Comparator
     *
     * @param c a Comparator that either "has" or "is" one int valued method
     */
    public EntityHolder(Comparator<E> c) {
        this.c = c;
        list = new ArrayList<E>();
    }

    //-----------FunctionalSortedSet METHODS - ONLY MODIFY filter!!------------

    public EntityHolder<E> filter(Predicate<E> p) {
        EntityHolder<E> last = new EntityHolder<E>(c);
        for (E element: list) {
            if (p.test(element)) {
                last.add(element);
            }
        }
        return last;
    }

    public EntityHolder<E> sort(Comparator<E> comparator) {
        EntityHolder<E> ret = new EntityHolder<E>(comparator);
        ret.addAll(this.list);
        return ret;
    }

    //------SortedSet METHODS - ONLY MODIFY subSet and tailSet!!---------------

    @Override
    public Comparator<? super E> comparator() {
        return c;
    }

    @Override
    public E first() {
        return list.get(0);
    }

    /**
     * Returns a EntityHolder object with all elements [first, toElement) using a
     * functional programming expression.
     *
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements strictly less than toElement.
     */
    @Override
    public EntityHolder<E> headSet(E toElement) {
        return list.subList(0, list.indexOf(toElement)).stream().collect(
                            Collectors.toCollection(()
                            -> new EntityHolder<>(c)));
    }

    /**
     * Return a EntityHolder object with all elements [fromElement, toElement)
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements fromElement to toElement.
     */
    @Override
    public EntityHolder<E> subSet(E fromElement, E toElement) {
        return list.subList(list.indexOf(fromElement),
            list.indexOf(toElement)).stream().collect(
                Collectors.toCollection(()
                -> new EntityHolder<>(c)));
    }

    /**
     * Return a EntityHolder object with all elements [fromElement, last]
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @return A sorted set containing elements fromElement and onwards.
     */
    @Override
    public EntityHolder<E> tailSet(E fromElement) {
        return list.subList(list.indexOf(fromElement),
            list.size() - 1).stream().collect(
                Collectors.toCollection(()
                -> new EntityHolder<>(c)));
    }

    @Override
    public E last() {
        return list.get(list.size() - 1);
    }

    //-----------Set METHODS - ---------------------------------------------

    @Override
    public boolean add(E e) {
        if (list.size() == 0) {
            list.add(e);
            return true;
        }
        if (!this.contains(e)) {
            ArrayList<E> temp = new ArrayList<E>();
            boolean flipper = true;
            for (int i = 0; i < list.size(); i++) {
                if (c.compare(list.get(i), e) > 0 && flipper) {
                    temp.add(e);
                    flipper = false;
                } else if (c.compare(list.get(list.size() - 1), e) < 0) {
                    list.add(e);
                    return true;
                }
                temp.add(list.get(i));
            }
            list.clear();
            for (E element: temp) {
                list.add(element);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(e)) {
                list.remove(i);
                list.trimToSize();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> col) {
        ArrayList<Boolean> results = new ArrayList<Boolean>();
        Iterator<?> iterator = col.iterator();
        while (iterator.hasNext()) {
            boolean result = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals((E) iterator.next())) {
                    result = true;
                }
            }
            results.add(result);
        }
        boolean finalResult = true;
        for (Boolean element: results) {
            if (!element) {
                finalResult = false;
            }
        }
        return finalResult;
    }

    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> col) {
        ArrayList<Boolean> results = new ArrayList<Boolean>();
        Iterator<?> iterator = col.iterator();
        while (iterator.hasNext()) {
            results.add(this.add((E) iterator.next()));
        }
        boolean finalResult = true;
        for (Boolean element: results) {
            if (!element) {
                finalResult = false;
            }
        }

        return finalResult;
    }

    @Override
    public boolean removeAll(Collection<?> col) {
        ArrayList<Boolean> results = new ArrayList<Boolean>();
        Iterator<?> iterator = col.iterator();
        while (iterator.hasNext()) {
            results.add(this.remove((E) iterator.next()));
        }
        boolean finalResult = true;
        for (Boolean element: results) {
            if (!element) {
                finalResult = false;
            }
        }
        return finalResult;
    }

    @Override
    public boolean retainAll(Collection<?> col) {
        this.clear();
        Iterator<?> iterator = col.iterator();
        while (iterator.hasNext()) {
            list.add((E) iterator.next());
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public void clear() {
        list = new ArrayList<E>();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (T) list.get(i);
        }
        return a;
    }

    @Override
    public String toString() {
        String listString = new String();
        for (E element: list) {
            listString += element + "\n";
        }
        return listString;
    }
}
