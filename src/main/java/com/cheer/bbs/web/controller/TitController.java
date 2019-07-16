package com.cheer.bbs.web.controller;

import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.pojoVo.TitlesVo;
import com.cheer.bbs.service.MesService;
import com.cheer.bbs.service.ProService;
import com.cheer.bbs.service.TitService;
import com.cheer.bbs.util.IOUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
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
           List<TitlesVo> titList = titService.getTitList();
           for (TitlesVo titles : titList) {
               //Progra pro2 = this.proService.getPro2(titles.getCname());
               if (titles.getAvatar() == null) {//判断user中有无头像：如果没有就是用默认的头像
                   titles.setAvatar("default.jpeg");
               } else {
                   ApplicationHome home = new ApplicationHome(getClass());
                   File sysfile = home.getSource();
                   String jarPath = sysfile.getPath();
                   String dest = jarPath + "/static/avatar/" + titles.getAvatar();
                   System.out.println(dest);
                   File avatar = new File(dest);
                   if (!avatar.exists()) {
                       String src = System.getProperty("user.home") + "/avatar/" + titles.getAvatar();//写入项目中指定文件夹
                       IOUtils.copy(src, dest);//把上传后的文件复制到指定项目文件夹中
                   }
                   //titles.setAvatar(pro2.getAvatar());
               }
           }
            List<TitlesVo> hotTit = this.titService.hotTit();
            model.addAttribute("hottit",hotTit);
            model.addAttribute("titlist",titList);
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
        Titles titles = new Titles(pro.getName(),title,message,date,0,0);
        //添加一条新的帖子
        this.titService.insPro(titles);
        //得到新帖子的id
        int tid = this.titService.tid();
        //更新帖子对应的回帖信息(针对发帖人的第一条信息，楼层数 1)
        Messages messages = new Messages(tid,message,1,titles.getCname(),date,1);
        this.mesService.insertMes(messages);
        return "redirect:getTitList";
    }


    @RequestMapping(value = "searTit",method= RequestMethod.POST)
    @ResponseBody
    public List<Titles> searTit(String tit){
        List<Titles> titles = this.titService.searTit(tit);
        return titles;
    }
}
