package com.example.homepage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupDTO {
    private String mid;
    private String mpassword;
    private String memail;
    private String musername;
    private String mphone;
}
