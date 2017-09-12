package com.team6.leangoo.service;

import com.team6.leangoo.mapper.BoardMapper;
import com.team6.leangoo.mapper.ProjectMapper;
import com.team6.leangoo.model.Board;
import com.team6.leangoo.model.Project;
import com.team6.leangoo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lfxiui
 * Date: 2017/9/6
 * Time: 9:10
 */
@Service
@Transactional
public class ArchiveService {
    @Autowired private ProjectMapper projectMapper;
    @Autowired private BoardMapper boardMapper;

    public List getArchivePros(User user){
        List<Project> projects=projectMapper.getArchiveProjects(user.getUserId());
        List list=new ArrayList();
        for(Project temp:projects){
            Map map=new HashMap();
            map.put("projectId",temp.getProjectId());
            map.put("projectName",temp.getProjectName());

            list.add(map);
        }
        return list;
    }
    public List getArchiveBoardList(User user){
        List<Board> boards = boardMapper.getArchiveBoards(user.getUserId());
        List list = new ArrayList();
        for (Board temp:boards){
            Map map = new HashMap();
            map.put("boardId",temp.getBoardId());
            map.put("boardName",temp.getBoardName());
            list.add(map);
        }
        return list;
    }
}
