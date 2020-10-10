package edu.waketech.csc251.collection;

import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.tools.Screener;

import java.util.*;

public class DataSetGeneric <E extends Measurable> extends ArrayList<E> {

    private ArrayList<E> data = new ArrayList<>();

    public DataSetGeneric() {
    }

    public boolean add(E obj){
        data.add(obj);
        return true;
    }

    public ArrayList<E> getMax() {
        if (data.isEmpty()) {
            return null;
        }
        E mEle = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (mEle.getSalary() < (data.get(i).getSalary())) {
                mEle = data.get(i);
            }
        }
        ArrayList<E> maxObj = new ArrayList<>();
        maxObj.add(mEle);
        return maxObj;
    }

    public ArrayList<E> getList() {
        return data;
    }

    public ArrayList<E> getList(Screener<E> screener){
        ArrayList<E> objList = new ArrayList<>();
        for (E element : data) {
            if (screener.isEquals(element)) {
                objList.add(element);
            }
        }
        return objList;
    }

    public int getSize(){
        return data.size();
    }


    public ArrayList<E> sortByName() {
        ArrayList<E> newList = new ArrayList<>(data);
        Comparator<E> compareName = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());
        newList.sort(compareName);
        return newList;
    }

    public ArrayList<E> sortBySalary(){
        ArrayList<E> newList = new ArrayList<>(data);
        Comparator<E> compareSalary = (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());
        newList.sort(compareSalary);
        return newList;
    }


    public ArrayList<String> generatePay(){
        ArrayList<String> payroll = new ArrayList<>();
        for (E element : data) {
            payroll.add("Pay " + element.getName() + " $ " + element.getSalary());
        }
        return payroll;
    }


    public String toString() {
        String allEmployees = "";
        for(int i = 0; i < data.size(); i++){
            allEmployees += "[" + i + "] " + data.get(i) + "\n";
        }
        return allEmployees;
    }
}