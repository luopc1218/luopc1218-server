package com.luopc1218.luopc1218server.entity.message;


import com.luopc1218.luopc1218server.entity.request.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetLeaveMessageListParams extends Pagination {
    public GetLeaveMessageListParams() {
    }

    public GetLeaveMessageListParams(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
