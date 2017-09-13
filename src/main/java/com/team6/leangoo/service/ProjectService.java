package com.team6.leangoo.service;

import com.team6.leangoo.mapper.ProjectMapper;
import com.team6.leangoo.mapper.ProjectUserMapper;
import com.team6.leangoo.model.Project;
import com.team6.leangoo.model.ProjectUser;
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
 * Date: 2017/9/13
 * Time: 10:11
 */
@Service
@Transactional
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectUserMapper projectUserMapper;

    public List getArchiveProjectList(User user){
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

    public int updateProject(Project project){
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    public List getUserProjectList(User user){
        return projectMapper.getUserProjectList(user.getUserId());
    }

    public int newProject(User user,Project project){
        if (projectMapper.newProject(project) == 1){
            Integer projectId = project.getProjectId();
            ProjectUser projectUser = new ProjectUser();
            projectUser.setUserId(user.getUserId());
            projectUser.setProjectId(projectId);
            if (projectUserMapper.insert(projectUser) > 0) return projectId;
        }
        return 0;
    }

    public Project getProjectInfo(Project project){
        return projectMapper.selectOne(project);
    }
}
