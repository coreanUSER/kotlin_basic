package com.ptk.kotilnsample;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DelegatingCollection<T> implements Collection<T> {
    private ArrayList<T> innterList = new ArrayList<>();

    @Override
    public int size() {
        return innterList.size();
    }

    @Override
    public boolean isEmpty() {
        return innterList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innterList.contains(o);
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return innterList.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return innterList.toArray();
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] t1s) {
        return innterList.toArray(t1s);
    }

    @Override
    public boolean add(T t) {
        return innterList.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return innterList.remove(o);
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return innterList.containsAll(collection);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends  T> collection) {
        return innterList.addAll(collection);
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return innterList.removeAll(collection);
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return innterList.removeAll(collection);
    }

    @Override
    public void clear() {
        innterList.clear();
    }
}
