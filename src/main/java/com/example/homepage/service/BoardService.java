package com.example.homepage.service;

import com.example.homepage.dto.BoardDTO;
import com.example.homepage.entity.BoardEntity;

import java.util.List;

public interface BoardService {

    public List<BoardDTO> getList();

    public boolean insertPost(BoardDTO boardDTO);

    public BoardDTO selectOnePost(int bno);

    public boolean deletePost(int bno);

    public int updatePost(BoardDTO boardDTO);

    // 엔티티에 저장된 시간 정보를 dto에 전달해줄 때는 전송 필수
    default BoardDTO boardEntityToDto(BoardEntity boardEntity){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(boardEntity.getBno())
                .btitle(boardEntity.getBtitle())
                .bwriter(boardEntity.getBwriter())
                .bcontent(boardEntity.getBcontent())
                .regdate(boardEntity.getRegdate())
                .moddate(boardEntity.getModdate())
                .bviewcnt(boardEntity.getBviewcnt())
                .build();

        return boardDTO;
    }

    // dto에 저장된 시간정보가 아닌 스스로 시간을 저장하므로 엔티티에 전달할 필요가 없음
    default BoardEntity boardDtoToEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = BoardEntity.builder()
                .bno(boardDTO.getBno())
                .btitle(boardDTO.getBtitle())
                .bwriter(boardDTO.getBwriter())
                .bcontent(boardDTO.getBcontent())
                .bviewcnt(boardDTO.getBviewcnt())
                .build();

        return boardEntity;
    }
}
