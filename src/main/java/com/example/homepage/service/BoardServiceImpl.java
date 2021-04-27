package com.example.homepage.service;

import com.example.homepage.dto.BoardDTO;
import com.example.homepage.entity.BoardEntity;
import com.example.homepage.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<BoardDTO> getList() {
        List<BoardEntity> result = boardRepository.findAllByOrderByBnoDesc();

        List<BoardDTO> list = result.stream().map(
                boardEntity -> boardEntityToDto(boardEntity)
        ).collect(Collectors.toList());

        /*
        List<BoardDTO> list = null;

        for(BoardEntity boardEntity : result){
            BoardDTO boardDTO = boardEntityToDto(boardEntity);
            list.add(boardDTO);
        }
        */

        return list;
    }

    @Override
    public boolean insertPost(BoardDTO boardDTO) {
        boolean result = true;

        BoardDTO postDTO = BoardDTO.builder()
                .btitle(boardDTO.getBtitle())
                .bwriter(boardDTO.getBwriter())
                .bcontent(boardDTO.getBcontent())
                .build();

        BoardEntity postEntity = boardDtoToEntity(postDTO);

        try {
            boardRepository.save(postEntity);
        } catch(Exception e){
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    @Override
    public BoardDTO selectOnePost(int bno) {
        Optional<BoardEntity> result = boardRepository.findById(bno);
        BoardDTO post = null;

        if(result.isPresent()){
            post = boardEntityToDto(result.get());
        }

        return post;
    }

    @Override
    public boolean deletePost(int bno) {
        boolean result = true;

        try{
            boardRepository.deleteById(bno);
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    @Override
    public int updatePost(BoardDTO boardDTO) {
        BoardEntity result = boardRepository.save(boardDtoToEntity(boardDTO));
        return result.getBno();
    }
}