package br.com.vitrocar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Car{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String brand;
    private String model;
    @ManyToOne
    @JoinColumn(name="user",nullable=false)
    private User user;
    //private x photo;

}