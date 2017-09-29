package com.team6.leangoo.mapper;

import com.team6.leangoo.model.Board;
import com.team6.leangoo.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardMapper extends MyMapper<Board> {
     List getArchiveBoards(Integer userId);
     Board getList(@Param("boardId") Integer boardId);
}