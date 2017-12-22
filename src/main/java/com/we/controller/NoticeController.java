package com.we.controller;


import com.we.bean.Notice;
import com.we.enums.RequestResultEnum;
import com.we.service.NoticeService;
import com.we.vo.RequestResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private NoticeService noticeService;

    @PostMapping("update")
    @ResponseBody
    public RequestResultVO update(Notice notice) {
        RequestResultVO vo = null;
        try{
            noticeService.update(notice);
            vo = RequestResultVO.status(RequestResultEnum.UPDATE_SUCCESS);
        }catch (RuntimeException e) {
            vo = RequestResultVO.status(RequestResultEnum.UPDATE_FAIL);
        }
        return vo;
    }

    @Resource
    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}