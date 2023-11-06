package com.InventorSoftAcademy.hibernateproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
    //    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "subject_id")
    private Long subject_Id;


    public Teacher(String firstname, String lastname, Long subject_Id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject_Id = subject_Id;
    }

}
