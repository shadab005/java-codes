package com.javatpoint.beans;    
public class Emp {  
private int id;  
private String name;  
private int salary;  
private String designation;  
  
public Emp() {}  
  
public Emp(int id, String name, int salary, String designation) {  
    super();  
    this.id = id;  
    this.name = name;  
    this.salary = salary;  
    this.designation = designation;  
}  
  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public int getSalary() {  
    return salary;  
}  
public void setSalary(int salary) {  
    this.salary = salary;  
}  
public String getDesignation() {  
    return designation;  
}  
public void setDesignation(String designation) {  
    this.designation = designation;  
}  
  
}  