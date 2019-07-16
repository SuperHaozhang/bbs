package com.cheer.bbs.web.controller;

import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.service.MesService;
import com.cheer.bbs.service.ProService;
import com.cheer.bbs.service.TitService;
import com.cheer.bbs.util.IOUtils;
import com.cheer.bbs.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //用于存储个人所有的帖子里的未读消息数
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

    @RequestMapping("/register")
    public String reg(Model model){
        Progra progra = new Progra();
        model.addAttribute("pro",progra);
        return "register";
    }


    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String regis(MultipartFile file, @Valid Progra pro, BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        String username = pro.getName();
        String password = pro.getPassword();
        String hiredate = pro.getHiredate();
        //LOGGER.debug(username+":::::"+password);
        Progra progar = new Progra();
        int insert = 0;
        try {
            progar.setName(username); //获取注册用户名
            //progar.setPassword(StringUtils.encrypt(password));//获取用户注册密码
            progar.setPassword(password);
            progar.setHiredate(hiredate);
            String fileName = file.getOriginalFilename();//获取上传文件名称
            System.out.println(fileName);
            String suffix = fileName.substring(fileName.lastIndexOf("."));//分解上传文件后缀名
            String avatar = username;
            String path = System.getProperty("user.home")+"/avatar/"+avatar+suffix;//设置上传文件对应用户名
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));//写入到头像文件夹中
            progar.setAvatar(avatar + suffix);
            insert = this.proService.insPro(progar);
            if(insert>0){
                return "redirect:/login";//跳转：登陆页面
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }


    @RequestMapping(value = "a",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> a(String username){
        Map<String,String> messgie = new HashMap<>();
        Progra pro = this.proService.getPro2(username);
        if(pro!=null){
            messgie.put("code","-1");
            messgie.put("message","用户名已经存在");
        }
        return messgie;
    }

}
