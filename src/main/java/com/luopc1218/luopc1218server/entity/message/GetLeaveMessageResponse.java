package com.luopc1218.luopc1218server.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetLeaveMessageResponse extends LeaveMessage {
    private String authorName;
    private String authorAvatarUrl;
}
