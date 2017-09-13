package com.team6.leangoo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_intro")
    private String projectIntro;

    @Column(name = "project_create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date projectCreateDate;

    @Column(name = "project_start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date projectStartDate;

    @Column(name = "project_end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date projectEndDate;
    @Column(name ="project_is_archive")
    private Integer projectIsArchive;

    //多表查询添加 project包含的boards添加BY啊喜20170913
    @Transient
    private List<Board> boardList = new ArrayList<>();

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }
    //-------啊喜

    public Integer getProjectIsArchive() {
        return projectIsArchive;
    }

    public void setProjectIsArchive(Integer projectIsArchive) {
        this.projectIsArchive = projectIsArchive;
    }

    /**
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return project_name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return project_intro
     */
    public String getProjectIntro() {
        return projectIntro;
    }

    /**
     * @param projectIntro
     */
    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    /**
     * @return project_create_date
     */
    public Date getProjectCreateDate() {
        return projectCreateDate;
    }

    /**
     * @param projectCreateDate
     */
    public void setProjectCreateDate(Date projectCreateDate) {
        this.projectCreateDate = projectCreateDate;
    }

    /**
     * @return project_start_date
     */
    public Date getProjectStartDate() {
        return projectStartDate;
    }

    /**
     * @param projectStartDate
     */
    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    /**
     * @return project_end_date
     */
    public Date getProjectEndDate() {
        return projectEndDate;
    }

    /**
     * @param projectEndDate
     */
    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }
}