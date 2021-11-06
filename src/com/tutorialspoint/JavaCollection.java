package com.tutorialspoint;

import java.util.*;

public class JavaCollection {
    List addressList;
    List<HelloWorld> addressListBean;

    Set addressSet;
    Set<HelloWorld> addressSetBean;

    Map addressMap;
    Map<Integer, HelloWorld> addressMapBean;

    Properties addressProp;

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public List<HelloWorld> getAddressListBean() {
        System.out.println("List Elements Bean :" + addressListBean);
        return addressListBean;
    }

    public void setAddressListBean(List<HelloWorld> addressListBean) {
        this.addressListBean = addressListBean;
    }

    public Set<HelloWorld> getAddressSetBean() {
        System.out.println("Set Elements Bean :" + addressSetBean);
        return addressSetBean;
    }

    public void setAddressSetBean(Set<HelloWorld> addressSetBean) {
        this.addressSetBean = addressSetBean;
    }

    public Map<Integer, HelloWorld> getAddressMapBean() {
        System.out.println("Map Elements Bean :" + addressMapBean);
        return addressMapBean;
    }

    public void setAddressMapBean(Map<Integer, HelloWorld> addressMapBean) {
        this.addressMapBean = addressMapBean;
    }

    // prints and returns all the elements of the list.
    public List getAddressList() {
        System.out.println("List Elements :" + addressList);
        return addressList;
    }

    // a setter method to set Set
    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    // prints and returns all the elements of the Set.
    public Set getAddressSet() {
        System.out.println("Set Elements :" + addressSet);
        return addressSet;
    }

    // a setter method to set Map
    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    // prints and returns all the elements of the Map.
    public Map getAddressMap() {
        System.out.println("Map Elements :" + addressMap);
        return addressMap;
    }

    // a setter method to set Property
    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    // prints and returns all the elements of the Property.
    public Properties getAddressProp() {
        System.out.println("Property Elements :" + addressProp);
        return addressProp;
    }
}
