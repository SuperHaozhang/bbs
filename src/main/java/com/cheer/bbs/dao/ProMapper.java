package com.cheer.bbs.dao;


import com.cheer.bbs.pojo.Progra;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProMapper {

    List<Progra> getList();

    Progra getPro(@Param("name") String name, @Param("password") String password);

    Progra getPro2(@Param("name") String name);

    int insPro(Progra pro);

    int update(Progra pro);

    int delete(int id);
}
