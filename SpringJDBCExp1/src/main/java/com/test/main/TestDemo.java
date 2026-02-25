package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.MLATeamDao;
import com.test.dao.MLATeamDao1;
import com.test.model.MLATeam;

public class TestDemo {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		MLATeamDao dao = ctx.getBean("tdao", MLATeamDao.class);
		
		MLATeamDao1 dao1 = ctx.getBean("tdao1",MLATeamDao1.class);
		
		MLATeam obj = new MLATeam();
		
		obj.setId(6);
		obj.setName("AJ");
		obj.setSkill("MI");
		obj.setManager("akj");
		
		//dao1.createMLATeam(obj);
		
		List<MLATeam> list = dao.getAllMembers();
		
		list.forEach(System.out::println);
		
//		dao.deleteMLATeamMember(1);
//		
//		list = dao.getAllMembers();
//		
//		list.forEach(System.out::println);
		
//		dao.updateMLATeam(obj);
	}
}
