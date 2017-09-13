package com.team6.leangoo.controller;

import com.team6.leangoo.model.User;
import com.team6.leangoo.service.BoardService;
import com.team6.leangoo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: lfxiui
 * Date: 2017/9/13
 * Time: 10:17
 */
@RestController
@RequestMapping("/Board")
public class BoardController {
    final
    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/getArchiveBoardList",method = RequestMethod.POST)
    public AjaxResult getArchiveBoardList(){
        Integer userId = 1;
        User user = new User();
        user.setUserId(userId);
        AjaxResult ajaxResult = new AjaxResult();
        try {
            ajaxResult.setData(boardService.getArchiveBoardList(user));
            ajaxResult.seterrcode(0);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }
}
