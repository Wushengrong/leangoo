package com.team6.leangoo.mapper;

import com.team6.leangoo.model.Board;
import com.team6.leangoo.util.MyMapper;

import java.util.List;

public interface BoardMapper extends MyMapper<Board> {
    public List getArchiveBoards(Integer userId);
}