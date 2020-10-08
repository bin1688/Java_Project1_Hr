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

    public void getSingleElement(int num){
        System.out.println(data.get(num));
    }

    public int getSize(){
        return data.size();
    }


    public List<E> sortBy(Comparator<? super E> comparator) {
        ArrayList<E> newList = new ArrayList<>(data);
        newList.sort(comparator);
        return newList;
    }

    public String toString() {
        String allEmployees = "";
        for(int i = 0; i < data.size(); i++){
            allEmployees += "[" + i + "] " + data.get(i) + "\n";
        }
        return allEmployees;
    }
}