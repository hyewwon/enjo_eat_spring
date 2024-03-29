package com.enjo_eat_spring.enjo_eat_spring.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "eatery_group")
public class EateryGroup extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_comment")
    private String groupComment;

    @Column(name = "group_location")
    private String groupLocation;

    @Column(name= "open_flag")
    private int openFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<Eatery> eateries = new ArrayList<>();

    public void update(String groupName, String groupComment, String groupLocation, int openFlag){
        this.groupName = groupName;
        this.groupComment = groupComment;
        this.groupLocation = groupLocation;
        this.openFlag = openFlag;
    }

}
