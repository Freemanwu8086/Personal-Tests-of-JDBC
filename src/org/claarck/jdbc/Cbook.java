package org.claarck.jdbc;

import java.util.Date;

public class Cbook {
    private String isbn,a_class,subclass,name,author,introduction;
    private double price;
    private Date pubdate;

    public Cbook(){

    }
    public Cbook(String isbn,String a_class,String subclass,String name,String author,String introduction,
                 Date pubdate,double price){
        super();
        this.isbn = isbn;
        this.a_class = a_class;
        this.subclass = subclass;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pubdate = pubdate;
        this.introduction = introduction;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getA_class(){
        return a_class;
    }
    public String getSubclass(){
        return subclass;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getIntroduction(){
        return introduction;
    }
    public Date getPubdate(){
        return pubdate;
    }
    public double getPrice(){
        return price;
    }
}
