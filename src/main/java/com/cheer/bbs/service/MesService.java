package com.cheer.bbs.service;

import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojoVo.TitlesVo;

import java.util.List;

public interface MesService {
    List<Messages> getMesList(int tid);

    int insertMes(Messages messages);

    int selectfloor(int tid);

    int countMes(int tid);

    int update(int tid);

    Messages getLastTime(int tid);
}
