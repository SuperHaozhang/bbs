package com.cheer.bbs.dao;

import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.pojoVo.TitlesVo;

import java.util.List;

public interface TitMapper {
    List<TitlesVo> getTitList();

    Titles getTit(int id);

    int insPro(Titles tit);

    int update(Titles tit);

    int delete(int id);

    int tid();

    List<Titles> getforname2Tit(String cname);

    List<TitlesVo> hotTit();

    List<Titles> searTit(String tit);
}
