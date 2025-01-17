package com;



import java.io.Serializable;



public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    

    private int pid;

    private String pname;

    private double price;



    // Constructor

    public Product(int pid, String pname, double price) {

        this.pid = pid;

        this.pname = pname;

        this.price = price;

    }



   

    public int getPid() {

        return pid;

    }



    public void setPid(int pid) {

        this.pid = pid;

    }



    public String getPname() {

        return pname;

    }



    public void setPname(String pname) {

        this.pname = pname;

    }



    public double getPrice() {

        return price;

    }



    public void setPrice(double price) {

        this.price = price;

    }



    @Override

    public String toString() {

        return "Product{" +

               "pid=" + pid +

               ", pname='" + pname + '\'' +

               ", price=" + price +

               '}';

    }

}
