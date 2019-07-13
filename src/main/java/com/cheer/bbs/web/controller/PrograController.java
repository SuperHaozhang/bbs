package com.cheer.bbs.web.controller;

import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
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
import java.util.List;

@Controller
@RequestMapping({"/system", "/"})
public class PrograController {

    @Resource
    private ProService proService;

    @Resource
    private TitService titService;

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
    public String avatar(Model model, @PathVariable String cname){
        Progra pro2 = this.proService.getPro2(cname);
        List<Titles> titles = this.titService.getforname2Tit(cname);
        model.addAttribute("nameTie",titles);
        model.addAttribute("proinfo",pro2);
        return "proInfo";
    }
}
