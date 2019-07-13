package com.cheer.bbs;

import com.cheer.bbs.dao.MesMapper;
import com.cheer.bbs.dao.ProMapper;
import com.cheer.bbs.dao.TitMapper;
import com.cheer.bbs.pojo.Messages;
import com.cheer.bbs.pojo.Progra;
import com.cheer.bbs.pojo.Titles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BbsApplicationTests {

    @Resource
    ProMapper proMapper;

    @Resource
    MesMapper mesMapper;

    @Resource
    TitMapper titMapper;
    @Test
    public void contextLoads() {
    }

}
