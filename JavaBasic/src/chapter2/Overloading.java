package chapter2;

// 오버로딩
// 같은 이름의 메서드를 여러 개 생성 할수 있도록 해주는 것 (ex : println)

// 오버로딩 조건
// 이름이 같아야 함, 매개변수의 조합이 달라야 함(매개변수 이름은 영향X)
// 반환타입만 다를 경우 오버로딩이 성립하지 않음
// 같은 클래스 내에서만 발생
public class Overloading {
	
	// 물건 금액 입력하면 총 금액
	double purchase (int productPrice) {
		double sum = productPrice * 1.1;
		return sum;
	}
	double purchase (int product1Price, int product2Price) {
		double sum = (product1Price + product2Price) * 1.1;
		return sum;
	}
	double purchase (double product1Price, int product2Price) {
		double sum = (product1Price + product2Price) * 1.1;
		return sum;
	}
	double purchase (int product1Price, double product2Price) {
		double sum = (product1Price + product2Price) * 1.1;
		return sum;
	}
	
	// 매개변수 이름은 오버로딩에 영향을 미치지 않음
	// double purchase (int price) {
	//	double sum = price * 1.1;
	//  return sum;
	//}
	
	// 반환타입은 오버로딩에 영향을 미치지 않음
	// int purchase (int productPrice) {
	//	int sum = (int) (productPrice * 1.1);
	//	return sum;
	//}
	
	///////////////////////////////////////////////////////////////
	// 메서드의 매개변수가 많아질때의 문제
	// 학생 : 학번, 이름, 나이, 전화번호, 수업, 성적
	static void studentInfoPrint(String studentNumber, String name, int age, 
								 String telNumber, String course, String grade) {
		System.out.println("학번 : " + studentNumber);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화번호 : " + telNumber);
		System.out.println("수업 : " + course);
		System.out.println("성적 : " + grade);
	}
	static void studentInfoPrint(Dto dto) {
		System.out.println("학번 : " + dto.studentNumber);
		System.out.println("이름 : " + dto.name);
		System.out.println("나이 : " + dto.age);
		System.out.println("전화번호 : " + dto.telNumber);
		System.out.println("수업 : " + dto.course);
		System.out.println("성적 : " + dto.grade);
	}
	/////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		studentInfoPrint("123456", "홍길동", 20, "010-1234-5678", "행정학", "A");
		
		Dto dto = new Dto();
		dto.studentNumber = "1234561";
		dto.name = "홍길동1";
		dto.age = 30;
		dto.telNumber = "010-4444-4444";
		dto.course = "행정법";
		dto.grade = "D";
		
		studentInfoPrint(dto);		
	}
}
class Dto{
	String studentNumber;
	String name;
	int age;
	String telNumber;
	String course;
	String grade;	 
}