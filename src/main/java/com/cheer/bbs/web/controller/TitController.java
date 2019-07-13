package com.cheer.bbs.web.controller;

import com.cheer.bbs.dao.MesMapper;
import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.service.MesService;
import com.cheer.bbs.service.ProService;
import com.cheer.bbs.service.TitService;
import com.cheer.bbs.util.IOUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TitController {
    @Resource
    private ProService proService;

    @Resource
    private MesService mesService;

    @Resource
    private TitService titService;
    
    @RequestMapping("getTitList")
    public String login(Model model) {
        List<Titles> titList = titService.getTitList();
        List<String> avalist = new ArrayList<>();
        for (Titles titles : titList) {
            Progra pro2 = this.proService.getPro2(titles.getCname());
            if (pro2.getAvatar() == null) {//判断user中有无头像：如果没有就是用默认的头像
                pro2.setAvatar("default.jpeg");
            } else {
                ApplicationHome home = new ApplicationHome(getClass());
                File sysfile = home.getSource();
                String jarPath = sysfile.getPath();
                String dest = jarPath + "/static/avatar/" + pro2.getAvatar();
                File avatar = new File(dest);
                if (!avatar.exists()) {
                    String src = System.getProperty("user.home") + "/avatar/" + pro2.getAvatar();//写入项目中指定文件夹
                    IOUtils.copy(src, dest);//把上传后的文件复制到指定项目文件夹中

                }
                avalist.add(pro2.getAvatar());
            }
        }
        model.addAttribute("titlist",titList);
        model.addAttribute("avatarlist",avalist);
        System.out.println(avalist);
        return "getTitList";

    }


    @RequestMapping("title")
    public String title(){
        return "title";
    }

    @PostMapping("title")
    public String title1(HttpServletRequest request){

        Progra pro = (Progra)request.getSession().getAttribute("pro");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        //登记发帖时间
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date now=new Date();

        String date = myFmt.format(now);
        Titles titles = new Titles(pro.getName(),title,message,date);
        //添加一条新的帖子
        this.titService.insPro(titles);
        //得到新帖子的id
        int tid = this.titService.tid();
        //更新帖子对应的回帖信息(针对发帖人的第一条信息，楼层数 1)
        Messages messages = new Messages(tid,message,1,titles.getCname(),date);
        this.mesService.insertMes(messages);
        return "redirect:getTitList";
    }


}
