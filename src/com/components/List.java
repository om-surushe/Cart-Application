package com.components;

import java.lang.reflect.Array;

public class List<E>{
    private Array array;

    public List(Class<E> type, int size) {
        this.array = (Array) Array.newInstance(type, size);
    }

    public int size() {
        return Array.getLength(array);
    }

    public void add(E obj){
        for (int i = 0; i < this.size(); i++) {
            if (Array.get(array, i) == null) {
                Array.set(array, i, obj);
                break;
            }
        }
    }

    public void remove(int i2){
        for (int i = 0; i < this.size(); i++) {
            if (Array.get(array, i) == i2) {
                Array.set(array, i, null);
                break;
            }
        }
    }

    public Object get(int index){
        return Array.get(array, index);
    }

    public void update(int index, E obj){
        Array.set(array, index, obj);
    }

}