package com.cheer.bbs.service.impl;

import com.cheer.bbs.dao.ProMapper;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.service.ProService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class ProServiceImpl implements ProService {
    @Resource
    private ProMapper proMapper;

    @Override
    public List<Progra> getList() {//测试OK
        List<Progra> list = proMapper.getList();
        return list;
    }

    @Override
    public Progra getPro(String name, String password) {
        Progra pro = this.proMapper.getPro(name, password);
        return pro;
    }

    @Override
    public Progra getPro2(String name) {
        Progra pro = this.proMapper.getPro2(name);
        return pro;
    }

    @Override
    public int insPro(Progra pro) {//测试OK
        int i = this.proMapper.insPro(pro);
        if(i>0){
            System.out.println("插入成功！");
            return i;
        }else {
            return i;
        }

    }

    @Override
    public int update(Progra pro) {
       int i = this.proMapper.update(pro);
        if(i>0){
            System.out.println("更新成功！");
            return i;
        }else {
            return i;
        }
    }

    @Override
    public int delete(int id) {
        int i = this.proMapper.delete(id);
        if(i>0){
            System.out.println("更新成功！");
            return i;
        }else {
            return i;
        }
    }
}
