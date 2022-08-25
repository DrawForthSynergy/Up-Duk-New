package com.shop.service;


import com.shop.entity.Board2;
import com.shop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board2 board){

        boardRepository.save(board);

    }

    public List<Board2> boardList(){
        return boardRepository.findAll();
    }



}
