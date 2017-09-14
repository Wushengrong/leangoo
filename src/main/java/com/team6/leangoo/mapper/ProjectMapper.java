package com.team6.leangoo.mapper;

import com.team6.leangoo.model.Project;
import com.team6.leangoo.util.MyMapper;

import java.util.List;

public interface ProjectMapper extends MyMapper<Project> {
    public List getArchiveProjects(int userId);
    public List getUserProjectList(int userId);
    public List getProjectLeaguerList(Integer projectId);
    public List getBoardListByProjectId(Integer projectId);
}