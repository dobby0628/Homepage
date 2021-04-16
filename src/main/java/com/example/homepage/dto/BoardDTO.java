package com.example.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int bno;
    private String btitle;
    private String bwriter;
    private String bcontent;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
    private int bviewcnt;
}