package com.luopc1218.luopc1218server.entity.message;


import lombok.Data;

@Data
public class LeaveMessage {
    private Integer id;
    private String content;
    private Integer authorId;
    private java.sql.Timestamp createTime;
}
