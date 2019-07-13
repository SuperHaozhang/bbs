package com.cheer.bbs.service.impl;

import com.cheer.bbs.dao.MesMapper;
import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.service.MesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class MesServiceImpl implements MesService {
    @Resource
    private MesMapper mesMapper;

    @Override
    public List<Messages> getMesList(int tid) {
        List<Messages> mesList = this.mesMapper.getMesList(tid);
        return mesList;
    }

    @Override
    public int insertMes(Messages messages) {
        int i = this.mesMapper.insertMes(messages);
        if(i>0){
            System.out.println("插入成功！");
            return i;
        }else {
            return i;
        }
    }

    @Override
    public int selectfloor(int tid) {
        int i = this.mesMapper.selectfloor(tid);
        return i;
    }

}
