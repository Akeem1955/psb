package com.prime_stack.customer_info.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer implements Persistable<String> { 
    @Id public String customerId;
    public String name;
    public int age;
    public String address;
    public String workSector;

    @Transient 
    @JsonIgnore
    private boolean isNew = true;

    public Customer(){}

    @Override
    @Nullable
    public String getId() {
        return customerId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void markAsNotNew() {
        isNew = false;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkSector() {
        return workSector;
    }

    public void setWorkSector(String workSector) {
        this.workSector = workSector;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", workSector='" + workSector + '\'' +
                '}';
    }
}
