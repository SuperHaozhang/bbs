package com.cheer.bbs.web.controller;

import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.service.MesService;
import com.cheer.bbs.service.ProService;
import com.cheer.bbs.service.TitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MesController {
    @Resource
    private MesService mesService;

    @Resource
    private TitService titService;

    @Resource
    private ProService proService;

    @GetMapping("/onetitle/{id}")//打印帖子内容和回帖消息
    public String onetitle(Model model, @PathVariable Integer id) throws Exception {
        Titles tit = this.titService.getTit(id);
        List<Messages> mesList = this.mesService.getMesList(id);
        List<String> avalist = new ArrayList<>();
        List<Long> timelist = new ArrayList<>();
        for (Messages messages : mesList) {
            Progra pro2 = this.proService.getPro2(messages.getCname());
            String avatar = pro2.getAvatar();
            avalist.add(avatar);

            String temp = messages.getDate();
            SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            Date  date= myFmt.parse(temp);
            //计算回复的时间转换成秒数
            long time = date.getTime()/1000;
            //获取当前时间
            Date now=new Date();
            long time1 = now.getTime()/1000;
            long l = time - time1;
            timelist.add(l);
        }
        model.addAttribute("avalist",avalist);
        model.addAttribute("title",tit);
        model.addAttribute("message",mesList);
        model.addAttribute("timelist",timelist);
        return "title-message";
    }


    @PostMapping("/inser/{id}")//回帖
    public String insMes(HttpServletRequest request, @PathVariable Integer id){
        Progra pro = (Progra)request.getSession().getAttribute("pro");
        String message = request.getParameter("message");
        //查询对应帖子的全部楼层，回帖后楼层+1
        int selectfloor = this.mesService.selectfloor(id)+1;

        //登记回复时间
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date now=new Date();

        String date = myFmt.format(now);

        Messages messages = new Messages(id,message,selectfloor,pro.getName(),date);
        int i = this.mesService.insertMes(messages);
        return "redirect:/onetitle/"+id;
    }
}
