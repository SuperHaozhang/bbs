package com.cheer.bbs.service;

import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import com.cheer.bbs.pojoVo.TitlesVo;

import java.util.List;

public interface TitService {
    List<TitlesVo> getTitList();

    Titles getTit(int id);

    int insPro(Titles tit);

    int update(Titles tit);

    int delete(int id);

    int tid();

    List<Titles> getforname2Tit(String cname);

    List<TitlesVo> hotTit();
}
