package com.cheer.bbs.web.controller;

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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/system", "/"})
public class PrograController {

    @Resource
    private ProService proService;

    @Resource
    private TitService titService;

    @Resource
    private MesService mesService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam("name") String name, @RequestParam String password, HttpServletRequest request) {
        Progra pro = proService.getPro(name, password);
        if (pro!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("pro",pro);
            return "redirect:getTitList";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/proinf/{cname}")
    public String avatar(Model model, @PathVariable String cname,HttpServletRequest request){
        //查出个人所有的帖子里的未读消息数
        List<Integer> countList = new ArrayList<>();
        Progra pro2 = this.proService.getPro2(cname);
        HttpSession session = request.getSession();
        Progra pro =(Progra)session.getAttribute("pro");

        List<Titles> titles = this.titService.getforname2Tit(cname);
        //计算个人所有帖子的所有未读消息
        int coun = 0;
        if(pro2.getName().equals(pro.getName())){
            for (Titles title : titles) {
                int countMes = this.mesService.countMes(title.getId());
                coun +=countMes;
                countList.add(countMes);
            }
            model.addAttribute("counMes",coun);
            System.out.println(countList);
        }

        model.addAttribute("nameTie",titles);
        model.addAttribute("proinfo",pro2);
        return "proInfo";
    }
}
