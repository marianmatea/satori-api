package com.satori.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_club"
    )
    @SequenceGenerator(
            name = "seq_club",
            allocationSize = 5
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "cis")
    private String cis;

    @Column(name = "cif")
    private String cif;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name="profile_pic")
    private byte[] profilePic;

    @OneToMany(mappedBy = "club")
    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "club")
    private List<Trainer> trainers = new ArrayList<>();
}