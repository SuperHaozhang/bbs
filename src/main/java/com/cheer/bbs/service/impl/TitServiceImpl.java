package com.cheer.bbs.service.impl;

import com.cheer.bbs.dao.TitMapper;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.pojoVo.TitlesVo;
import com.cheer.bbs.service.TitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class TitServiceImpl implements TitService {
    @Resource
    private TitMapper titMapper;

    @Override
    public List<TitlesVo> getTitList() {
        List<TitlesVo> titList = this.titMapper.getTitList();
        return titList;
    }

    @Override
    public Titles getTit(int id) {
        Titles tit = this.titMapper.getTit(id);
        return tit;
    }

    @Override
    public int insPro(Titles tit) {
        int i = this.titMapper.insPro(tit);
        if(i>0){
            System.out.println("插入成功！");
            return i;
        }else {
            return i;
        }
    }

    @Override
    public int update(Titles tit) {
        int update = this.titMapper.update(tit);
        if(update>0){
            System.out.println("插入成功");
            return update;
        }else {
            System.out.println("插入失败");
            return update;
        }
    }

    @Override
    public int delete(int id) {
        int i = this.titMapper.delete(id);
        return i;
    }

    @Override
    public int tid() {
        int tid = this.titMapper.tid();
        return tid;
    }

    @Override
    public List<Titles> getforname2Tit(String cname) {
        List<Titles> name2List = this.titMapper.getforname2Tit(cname);
        return name2List;
    }

    @Override
    public List<TitlesVo> hotTit() {
        List<TitlesVo> titlesVos = this.titMapper.hotTit();
        return titlesVos;
    }


}
