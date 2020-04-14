package com.fea.project;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fea.project.workorder.model.vo.WorkorderNumModelVo;
import com.fea.project.workorder.util.WorkorderNumUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {


    
    
    public static void main(String[] args) {
    	System.out.println(WorkorderNumUtil.getNum());
	}

}
