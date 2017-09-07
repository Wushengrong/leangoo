package com.team6.leangoo.controller;

import com.team6.leangoo.service.ArchiveService;
import com.team6.leangoo.util.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: lfxiui
 * Date: 2017/9/6
 * Time: 11:08
 */
@RestController
public class ArchiveController {
    private final ArchiveService archiveService;
    private Integer userId = 1;

    public ArchiveController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @RequestMapping(value = "/getArchiveProject",method = RequestMethod.POST)
    public AjaxResult getArchiveProject(){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            ajaxResult.setData(archiveService.getArchivePros(userId));
            ajaxResult.seterrcode(0);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }

    @RequestMapping(value = "/getArchiveBoardList",method = RequestMethod.POST)
    public AjaxResult getArchiveBoardList(){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            ajaxResult.setData(archiveService.getArchiveBoardList(userId));
            ajaxResult.seterrcode(0);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }
}
