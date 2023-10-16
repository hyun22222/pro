package project.pro.board.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BoardDto {
    private int uid;
    private String title;
    private String writer;
    private int views;
    private LocalDateTime regdate;
    private String text;
    private int category;
    private int abc;
    private int mp;

    public BoardDto() {
    }

    public BoardDto(int uid, String title, String writer, int views, LocalDateTime regdate, String text, int category, int abc) {
        this.uid = uid;
        this.title = title;
        this.writer = writer;
        this.views = views;
        this.regdate = regdate;
        this.text = text;
        this.category = category;
        this.abc = abc;
    }

    /*private int id;*/

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getAbc() {
        return abc;
    }

    public void setAbc(int abc) {
        this.abc = abc;
    }


    @Override
    public String toString() {
        return "BoardDto{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", views=" + views +
                ", regdate=" + regdate +
                ", text='" + text + '\'' +
                ", category=" + category +
                ", abc=" + abc +
                '}';
    }
}
