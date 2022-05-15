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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_category"
    )
    @SequenceGenerator(
            name = "seq_category",
            allocationSize = 5
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "style")
    private String style;

    @Column(name = "weight")
    private String weight;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToMany
    @JoinTable(
            name = "category_member",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members;

    @OneToMany(mappedBy = "category")
    List<Result> results = new ArrayList<>();
}