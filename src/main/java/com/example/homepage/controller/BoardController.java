package com.example.homepage.controller;

import com.example.homepage.dto.BoardDTO;
import com.example.homepage.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        List<BoardDTO> lists = boardService.getList();

        model.addAttribute("lists", lists);
    }

    @GetMapping("/write")
    public void write(){

    }

    @PostMapping("/write")
    public String write(@ModelAttribute BoardDTO boardDTO) {
        boolean result = boardService.insertPost(boardDTO);

        if (result) {
            return "redirect:list";
        }
        return "redirect:write";
    }

    @RequestMapping("/post")
    public void selectOne(@RequestParam("bno") int bno, Model model){
        System.out.println("bno : " + bno);
        BoardDTO boardDTO = boardService.selectOnePost(bno);
        if(boardDTO == null){
            System.out.println("null");
        }
        else{
            System.out.println("success : " + boardDTO.toString());
        }

        model.addAttribute("post", boardDTO);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("bno")int bno){
        boolean result = boardService.deletePost(bno);

        return "redirect:list";
    }

    @GetMapping("/update")
    public void update(@RequestParam("bno")int bno, Model model){
        BoardDTO post = boardService.selectOnePost(bno);

        model.addAttribute("post", post);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO){
        int bno = boardService.updatePost(boardDTO);

        return "redirect:post?bno="+bno;
    }
}