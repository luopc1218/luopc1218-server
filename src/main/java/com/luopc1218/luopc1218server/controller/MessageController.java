package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.message.AddLeaveMessageBody;
import com.luopc1218.luopc1218server.entity.message.GetLeaveMessageListParams;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/addLeaveMessage", method = RequestMethod.POST)
    public ApiResponse addLeaveMessage(HttpServletRequest request, @RequestBody AddLeaveMessageBody addLeaveMessageBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            if (userId != null) {
                addLeaveMessageBody.setAuthorId(userId);
            }

            return ApiResponse.success(messageService.addLeaveMessage(addLeaveMessageBody));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getLeaveMessageList", method = RequestMethod.GET)
    public ApiResponse getLeaveMessageList(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        try {
            return ApiResponse.success(messageService.getLeaveMessageList(new GetLeaveMessageListParams(page, pageSize)));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
