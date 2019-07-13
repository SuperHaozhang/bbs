package com.cheer.bbs.service;


import com.cheer.bbs.pojo.Progra;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProService {

    List<Progra> getList();

    Progra getPro(String name, String password);

    Progra getPro2(@Param("name") String name);

    int insPro(Progra pro);

    int update(Progra pro);

    int delete(int id);
}
