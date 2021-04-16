package com.example.homepage.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "board")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    private String btitle;
    private String bwriter;
    private String bcontent;
    private int bviewcnt;
}
