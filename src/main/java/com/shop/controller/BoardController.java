package com.shop.controller;

import com.shop.entity.Board2;
import com.shop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm(){

        return "board/boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board2 board){
        boardService.write(board);

        return "";
     }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.boardList());
        return "board/boardlist";
    }
}
