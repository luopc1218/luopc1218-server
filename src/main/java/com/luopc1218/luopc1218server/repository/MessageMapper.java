package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.message.AddLeaveMessageBody;
import com.luopc1218.luopc1218server.entity.message.GetLeaveMessageListParams;
import com.luopc1218.luopc1218server.entity.message.GetLeaveMessageResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {

    void addLeaveMessage(@Param("addLeaveMessageBody") AddLeaveMessageBody addLeaveMessageBody);

    GetLeaveMessageResponse getLeaveMessageById(Integer messageId);

    List<GetLeaveMessageResponse> getLeaveMessageList(@Param("getLeaveMessageListParams") GetLeaveMessageListParams getLeaveMessageListParams);

    Integer getLeaveMessageListCount(@Param("getLeaveMessageListParams") GetLeaveMessageListParams getLeaveMessageListParams);
}
