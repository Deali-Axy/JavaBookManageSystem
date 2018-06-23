package da.Core.Model;

import java.util.*;

/**
 * QuerySet
 */
public class QuerySet implements List<ModelBase> {
    private ArrayList<ModelBase> querySet;

    public QuerySet() {
        this.querySet = new ArrayList<>();
    }


    @Override
    public int size() {
        return querySet.size();
    }

    @Override
    public boolean isEmpty() {
        return querySet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return querySet.contains(o);
    }

    @Override
    public Iterator<ModelBase> iterator() {
        return querySet.iterator();
    }

    @Override
    public Object[] toArray() {
        return querySet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return querySet.toArray(ts);
    }

    @Override
    public boolean add(ModelBase modelBase) {
        return querySet.add(modelBase);
    }

    @Override
    public boolean remove(Object o) {
        return querySet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return querySet.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends ModelBase> collection) {
        return querySet.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends ModelBase> collection) {
        return querySet.addAll(i, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return querySet.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return querySet.retainAll(collection);
    }

    @Override
    public void clear() {
        querySet.clear();
    }

    @Override
    public ModelBase get(int i) {
        return querySet.get(i);
    }

    @Override
    public ModelBase set(int i, ModelBase modelBase) {
        return querySet.set(i, modelBase);
    }

    @Override
    public void add(int i, ModelBase modelBase) {
        querySet.add(i, modelBase);
    }

    @Override
    public ModelBase remove(int i) {
        return querySet.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return querySet.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return querySet.lastIndexOf(o);
    }

    @Override
    public ListIterator<ModelBase> listIterator() {
        return querySet.listIterator();
    }

    @Override
    public ListIterator<ModelBase> listIterator(int i) {
        return querySet.listIterator(i);
    }

    @Override
    public List<ModelBase> subList(int i, int i1) {
        return querySet.subList(i, i1);
    }
}
