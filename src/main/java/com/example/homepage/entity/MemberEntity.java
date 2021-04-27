package com.example.homepage.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity{
    @Id
    private String mid;
    private String mpassword;
    private String musername;
    private String memail;
    private String mphone;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }
}
