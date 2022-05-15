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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_trainer"
    )
    @SequenceGenerator(
            name = "seq_trainer",
            allocationSize = 5
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_id_expiry")
    private LocalDate memberIdExpiry;

    @Column(name = "training_type")
    private String trainingType;

    @Lob
    @Column(name="profile_pic")
    private byte[] profilePic;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
}