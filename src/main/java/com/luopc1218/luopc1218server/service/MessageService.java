package com.luopc1218.luopc1218server.service;

import com.luopc1218.luopc1218server.entity.message.AddLeaveMessageBody;
import com.luopc1218.luopc1218server.entity.message.GetLeaveMessageListParams;
import com.luopc1218.luopc1218server.entity.message.GetLeaveMessageResponse;
import com.luopc1218.luopc1218server.entity.request.PaginationData;
import com.luopc1218.luopc1218server.repository.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageMapper messageMapper;

    public PaginationData<GetLeaveMessageResponse> getLeaveMessageList(GetLeaveMessageListParams getLeaveMessageListParams) throws RuntimeException {
        List<GetLeaveMessageResponse> leaveMessageList = messageMapper.getLeaveMessageList(getLeaveMessageListParams);
        Integer leaveMessageListCount = this.getLeaveMessageListCount(getLeaveMessageListParams);
        return new PaginationData<>(leaveMessageList, leaveMessageListCount);
    }

    public Integer getLeaveMessageListCount(GetLeaveMessageListParams getLeaveMessageListParams) throws RuntimeException {
        return messageMapper.getLeaveMessageListCount(getLeaveMessageListParams);
    }

    public GetLeaveMessageResponse getLeaveMessageById(Integer messageId) throws RuntimeException {
        return messageMapper.getLeaveMessageById(messageId);
    }

    public GetLeaveMessageResponse addLeaveMessage(AddLeaveMessageBody addLeaveMessageBody) throws RuntimeException {
        messageMapper.addLeaveMessage(addLeaveMessageBody);
        return this.getLeaveMessageById(addLeaveMessageBody.getId());
    }
}
