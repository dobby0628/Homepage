package com.example.homepage.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class MemberDTO extends User {
    private String mid;
    private String mpassword;
    private String memail;
    private String musername;
    private String mphone;

    public MemberDTO(String username, String password, Collection<? extends GrantedAuthority> authority) {
        super(username, password, authority);

        this.mid = username;
        this.mpassword = password;
    }
}
