package edu.waketech.csc251.collection;

import java.util.*;

public class DataSetGeneric <E extends Measurable> extends ArrayList<E> {

    private ArrayList<E> data = new ArrayList<>();

    public DataSetGeneric() {
    }

    public boolean add(E obj){
        data.add(obj);
        return true;
    }

    public E getMin() {
        if (data.isEmpty()) {
            return null;
        }
        E mEle = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (mEle.getMeasure() > (data.get(i).getMeasure())) {
                mEle = data.get(i);
            }
        }
        return mEle;
    }

    public E getMax() {
        if (data.isEmpty()) {
            return null;
        }
        E mEle = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (mEle.getMeasure() < (data.get(i).getMeasure())) {
                mEle = data.get(i);
            }
        }
        return mEle;
    }

    public List<E> getList() {
        return data;
    }

//    public List<E> sortBy(Comparator<? super E> comparator) {
//        ArrayList<E> newList = (ArrayList<E>) data.clone();
//        Collections.sort(newList, comparator);
//        return newList;
//    }

    public List<E> sortBy(Comparator<? super E> comparator) {
        ArrayList<E> newList = new ArrayList<>(data);
        newList.sort(comparator);
        return newList;
    }
    //jjjjjjjjjjjjjjjjjjjjj
    public String toString() {
        return ("The number of books in the store is: " + data.size() + "\nThe smallest books is: " + getMin() + "\nThe largest book is: " + getMax() +
            "\nThe original order of the list: " + getList());
    }
}