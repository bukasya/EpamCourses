package collections;

import java.util.*;

public class CustomArrayList<T> implements List<T> {
    public static final int CAPACITY = 10;

    private Object[] data = new Object[CAPACITY];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                if (o == null) {
                    return true;
                }
            } else if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size == data.length) {
            int newLength = (data.length * 3) / 2 + 1;
            data = Arrays.copyOf(data, newLength);
        }
        data[size++] = t;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(data.length < size + c.size()){
            int newLength = (data.length * 3) / 2 + c.size();
            data = Arrays.copyOf(data, newLength);
        }
        for (T element: c) {
            data[++size] = element;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if(data.length < size + c.size()){
            int newLength = (data.length * 3) / 2 + c.size();
            data = Arrays.copyOf(data, newLength);
        }
        int length = size + c.size() - index;
        System.arraycopy(data, index, data, index+c.size(), length+1);
        for (T element: c) {
            data[index++] = element;
            size++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        data = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if(index > 0 && index <= size){
            T oldElement = (T) data[index];
            data[index] = element;
            return oldElement;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            int newLength = (data.length * 3) / 2 + 1;
            data = Arrays.copyOf(data, newLength);
        }
        int length = size - index;
        System.arraycopy(data, index, data, index+1, length+1);
        size++;
        data[index] = element;
    }

    @Override
    public T remove(int index) {
        int length = data.length - index;
        T value = (T) data[index];
        System.arraycopy(data, index + 1, data, index, length-1);
        size--;
        return value;
    }

    @Override
    public int indexOf(Object o) throws NoSuchElementException {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public int lastIndexOf(Object o) throws NoSuchElementException {
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                lastIndex = i;
            }
        }
        if(lastIndex >= 0){
            return lastIndex;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if(fromIndex > 0 && toIndex > 0){
            if(fromIndex <= size && toIndex <= size){
                if(fromIndex < toIndex){
                    List<T> newList = new CustomArrayList<>();
                    for (int i = fromIndex; i <= toIndex; i++){
                        newList.add((T) data[i]);
                    }
                    return newList;
                }
                throw new IllegalArgumentException();
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
