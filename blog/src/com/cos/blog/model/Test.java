package com.cos.blog.model;

import lombok.Builder;
import lombok.Data;

//빌더패턴 
//자기자신을 계속리턴
public class Test {
	public static void main(String[] args) {
		대통령 d = 대통령.builder()
				.id(2)
				.name("bb")
				.phone("aa")
				.build();
	}
}
@Data //getter, setter
@Builder
class 대통령 {
	//new가되지않아도 instance는 메모리에뜸
	private int id;
	private String name;
	private String phone;
	private String addr;
	
	
}