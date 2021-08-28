package br.com.vitrocar.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="\"user\"") //word user is a reserved keyword in PostgreSQL
public class User{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy="car", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<Car>();
}
