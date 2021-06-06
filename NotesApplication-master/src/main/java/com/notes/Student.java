package com.notes;
class Student {
 
    // private member variables
    private int id;
    private String name;
    private double percentage;
    private int rank;
 
    // public 4-arg constructor
    public Student(int id, String name, double percentage, int rank) {
        super();
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.rank = rank;
    }
 
    // getters & setters
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
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
     
    // toString() method
    @Override
    public String toString() {
        return "Student [id=" + id 
                + ", name=" + name 
                + ", percentage=" + percentage 
                + ", rank=" + rank 
                + "]";
    }
}