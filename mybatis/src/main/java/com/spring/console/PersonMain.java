package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonDTO;
import com.spring.service.PersonService;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		PersonService service = (PersonService)ctx.getBean("person");
		
		//»ðÀÔ
//		PersonDTO insertPerson = new PersonDTO("hong123","È«±æµ¿");
//		System.out.println(service.insertPerson(insertPerson)?"¼º°ø":"½ÇÆÐ");
		
		//»èÁ¦
		List<PersonDTO> list = service.getRows();
		for (PersonDTO psersondto : list) {
			System.out.println(psersondto);
		}
		//¼öÁ¤ 
//		System.out.println(service.updatePerson(new PersonDTO("kim","±è")));
//		System.out.println(service.deletePerson("3"));
		System.out.println(service.getRow("4"));

	}

}
