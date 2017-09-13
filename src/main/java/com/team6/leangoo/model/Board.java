package com.team6.leangoo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
@ToString
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "board_id")
    private Integer boardId;

    @Column(name = "board_name")
    private String boardName;

    @Column(name = "board_start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date boardStartDate;

    @Column(name = "board_end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date boardEndDate;

    @Column(name = "board_start")
    private Integer boardStart;

    @Column(name = "board_locate")
    private Integer boardLocate;
    @Column(name = "board_is_archive")
    private Integer boardIsArchive;

    public Integer getBoardIsArchive() {
        return boardIsArchive;
    }

    public void setBoardIsArchive(Integer boardIsArchive) {
        this.boardIsArchive = boardIsArchive;
    }

    /**
     * @return board_id
     */
    public Integer getBoardId() {
        return boardId;
    }

    /**
     * @param boardId
     */
    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    /**
     * @return board_name
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * @param boardName
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    /**
     * @return board_start_date
     */
    public Date getBoardStartDate() {
        return boardStartDate;
    }
    /**
     * @param boardStartDate
     */
    public void setBoardStartDate(Date boardStartDate) {
        this.boardStartDate = boardStartDate;
    }

    /**
     * @return board_end_date
     */
    public Date getBoardEndDate() {
        return boardEndDate;
    }

    /**
     * @param boardEndDate
     */
    public void setBoardEndDate(Date boardEndDate) {
        this.boardEndDate = boardEndDate;
    }

    /**
     * @return board_start
     */
    public Integer getBoardStart() {
        return boardStart;
    }

    /**
     * @param boardStart
     */
    public void setBoardStart(Integer boardStart) {
        this.boardStart = boardStart;
    }

    /**
     * @return board_locate
     */
    public Integer getBoardLocate() {
        return boardLocate;
    }

    /**
     * @param boardLocate
     */
    public void setBoardLocate(Integer boardLocate) {
        this.boardLocate = boardLocate;
    }
}