package com.luopc1218.luopc1218server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetNoticeResponse extends Notice {
    private String authorName;
    private String authorAvatarUrl;
}
