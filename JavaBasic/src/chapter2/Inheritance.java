package chapter2;

import chapter1.Hello;

class Human {
	String name;
	int age;
	String address;
	
//	Human(String name, int age, String address){
//		this.name = name;
//		this.age = age;
//		this.address = address;
//	}
//	
	void eat(String food) {
		System.out.println(food + "을/를 먹는다.");
	}
}
// 직업

class Teacher extends Human {
	String school;
	int gradeClass; 

	void teaching() {
		System.out.println(gradeClass + "에서 수업을 한다.");
	}
	
	void eat() {
		System.out.println(school + "에서 밥을 먹습니다.");
	}
	void eat(String food) {
		System.out.println(school + "에서 " + food + "을/를 먹습니다.");
	}
	
}

class Police{
	String name;
	int age;
	String address;
	String position;
	String area;
	
	void eat(String food) {
		System.out.println(food + "을/를 먹는다.");
	}
	void patrol() {
		System.out.println(area + "를 순찰합니다.");
	}
}
public class Inheritance {

	public static void main(String[] args) {
		
		Human human = new Human();
		
		Teacher teacher = new Teacher();
		teacher.name = "선생님1";
		teacher.school = "한국고등학교";
		
		human.eat("밥");
		teacher.eat();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
