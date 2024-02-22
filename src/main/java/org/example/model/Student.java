package org.example.model;

public class Student {

    private int id;
    private String name;
    private double feesPaid;


    public Student(int id, String name, double feesPaid) {
        this.id = id;
        this.name = name;
        this.feesPaid = 0;
    }

    // Method to allow partial payment of tuition fee
    public void payFees(double amount) {
        if (feesPaid + amount <= 5000) {
            feesPaid += amount;
            System.out.println(name + " has paid $" + amount + " towards tuition fees.");
        } else {
            System.out.println("Error: Cannot pay more than the total tuition fee.");
        }
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

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feesPaid=" + feesPaid +
                '}';
    }
}
