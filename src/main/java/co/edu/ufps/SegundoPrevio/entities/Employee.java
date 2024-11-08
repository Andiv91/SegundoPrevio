package co.edu.ufps.SegundoPrevio.entities;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    private Date entryDate;

    @ManyToOne
    @JoinColumn(name = "pos_id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    private List<Visit> visits;

    @OneToMany(mappedBy = "employee")
    private List<Project_Assignment> projectAssignments;

}
