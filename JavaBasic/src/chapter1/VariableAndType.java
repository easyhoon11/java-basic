package chapter1;

public class VariableAndType {

	public static void main(String[] args) {
		// 변수
		// 데이터를 저장하는 메모리 공간
		// 메모리 공간을 할당하는 행위를 '변수를 선언한다'라고 함.
		// 할당한 메모리 공간에 첫 데이터를 넣는 행위를 '변수를 초기화한다'라고 함.
		
		// 변수 선언 방법
		// 데이터타입 변수명;
		int number;
		
		// 변수 초기화 방법
		// 변수명 = 초기데이터;
		number = 100;
		
		// 변수 선언과 동시에 초기화
		double pie = 3.14;
		
		System.out.println(number);
		System.out.println(pie);
		
		
		// 주의 사항
		// 1. 변수는 선언한 이후에 사용할 수 있음(선언하지 않은 변수는 사용 불가)
		
		// 2. 동일한 변수명을 중복해서 선언할 수 없음
		
		// 3. 선언한 변수는 반드시 초기화가 되어야 함
		// int age;
		// System.out.println(age);
		
		// 4. 변수 선언시에는 변수 명명 규칙을 따라야 함
		// 컴파일이 불가능한 명명 규칙
		
		// 4-1. 변수명에 특수문자 불가능 ($, _ 제외)
		// 4-2. 문법상의 키워드 사용 불가능 (ex) int, package, String....)
		// 4-3. 변수명의 첫글자가 숫자일 수 없음
		// 4-4. 변수명은 대소문자를 구분함
		int Num = 100; int num = 101;
		
		// 컴파일은 되지만 개발자 간의 암묵적인 규칙
		// - 변수명은 lowerCameCase 규칙을 따라야함
		
		// 명명 규칙
		// 1. Camel Case : 
		// 띄어쓰기 위치를 표현하기 위하여 띄어쓰기 뒤에오는 첫 문자를 대문자로 표기한다
		// 예) Hello world-> HelloWorld
		
		// 1-1. lowerCamelCase : 첫 글자를 무조건 소문자로 지정
		// 1-2. UpperCamelCase : 첫 글자를 무조건 대문자로 지정
		
		// 2. Snake Case :
		// 띄어쓰기를 '_'로 표기
		// 예) Hello world -> Hello_world
		
		// 2-1. lower_snake_case : 모든 문자를 소문자로 표기
		// 2-2. UPPER_SNAKE_CASE : 모든 문자를 대문자로 표기
		
		// lowerCamelCase : 변수, 메서드
		// UpperCamelCase : 클래스, 인터페이스
		// lower_snake_case : 안쓰임 (JSP에서 java 변수와 js 변수를 구분짓기 위한 js의 변수명)
		// UPPER_SNAKE_CASE : 상수
		
		// 변수에 값 재할당
		number = 999;
		
		// 상수
		// 한번 초기화하면 변경할 수 없는 변수
		// final 키워드를 사용하여 변수 선언 가능
		// 명명 규칙은 기본 변수 명명 규칙 + UPPER_SNAKE_CASE
		
		// 선언 방법
		// final 데이터타입 상수명;
		
		// 상수는 재할당 불가능
		
		// 선언과 동시에 초기화
		final int NUMBER = 1000;
		
		// 상수를 사용하는 이유
		// 1. 값의 보호 : 상수로 지정되어있는 데이터를 변경할 수 없도록 강제로 막음
		// 2. 코드의 가독성 증가 : 데이터에 이름을 부여함으로써 코드의 가독성을 증가
		
		
		
		// 데이터 타입
		// 자바의 변수는 여러 형태의 데이터를 저장할 수 있음
		// 해당 변수에 저장할 수 있는 데이터의 형태를 데이터 타입이라 함
		// 데이터 타입 - 기본형 데이터 타입 / 참조형 데이터 타입
		
		// 기본형 데이터 타입
		// 실제로 데이터를 저장하고 있는 변수의 타입
		// 1. 정수형 타입
		// 2. 실수형 타입
		// 3. 문자형 타입
		// 4. 논리형 타입
		
		// 정수형 타입 : 정수만 담을 수 있는 데이터 타입
		// (byte, short, int, long)
		
		// - byte 
		//   1byte (8bit)의 메모리 공간을 차지함
		//   -128 ~ 127
		byte byteVariable;
		byteVariable = 127;
		byteVariable = -128;
		// byteVariable = 128;
		
		// - short
		//   2byte (16bit)의 메모리 공간을 차지함
		//	 -32,768 ~ 32,767
		short shortVariable;
		shortVariable = 32767;
		shortVariable = -32768;
		// shortVariable = 32768;
		
		// - int
		//   4byte (32bit)의 메모리 공간을 차지함
		//	 -2^31 ~ 2^31-1 
		int intVariable;
		intVariable = 2_147_483_647;
		intVariable = -2_147_483_648;
		
		// intVariable = 2_147_483_649;
		
		// - long
		//	 8byte (64bit)의 메모리 공간을 차지함
		//   -2^63 ~ 2^63-1
		// 	 숫자 마지막에 l,L 붙힘
		long longVariable;
		longVariable = 2_147_483_649L;
		
		// 실수형 타입 : 실수와 정수를 모두 담을 수 있는 데이터 타입
		// (float, double)
		
		// - float
		//	 4byte (32bit)의 메모리 공간을 차지함
		//   소수점 6~7 자리에서 오차 발생
		// 	 끝자리에 f,F 붙힘
		float floatVariable;
		floatVariable = 3.14151617F;
		System.out.println(floatVariable);
		
		// - double
		//	 8byte (64bit)의 메모리 공간을 차지함
		//	 소수점 15 ~ 17 자리에서 오차 발생
		double doubleVariable;
		doubleVariable = 3.141516171819;
		System.out.println(doubleVariable);
		
		// 문자형 타입 : 문자(유니코드 및 아스키코드)를 담을 수 있는 데이터 타입
		// -char 
		//	2byte (16bit)의 메모리 공간을 차지함
		//	문자 하나만 담을 수 있음, 아스키 코드, 유니 코드 또한 담을 수 있음
		char charVariable;
		charVariable = 'A';
		System.out.println(charVariable);
		
		charVariable = 97;
		System.out.println(charVariable);
		
		// 논리형 타입 : 논리 값을 담을 수 있는 데이터 타입
		// true, false의 값으 가질 수 있음
		// -boolean
		//	1byte (8bit)의 메모리 공간을 차지함
		boolean booleanVariable;
		booleanVariable = true;
		
		// 형변환
		// 특정 변수를 다른 데이터 타입의 변수로 옮기는 것
		// 자동 형변환 - 강제 형변환
		
		// 자동 형변환 : 같은 타입일때 작은 데이터 타입을 큰 데이터 타입으로
		//			  형변환 할 때는 자바가 알아서 형변환을 진행
		byteVariable = 10;
		shortVariable = byteVariable;
		
		floatVariable = 3.14F;
		doubleVariable = floatVariable;
		
		// 강제 형변환 : 다른 타입이거나 큰 데이터 타입을 작은 데이터 타입으로
		//			  형변환 할 때는 개발자가 명시적으로 형변환을 해야 함
		byteVariable = (byte) shortVariable; 
		floatVariable = (float) doubleVariable;
		
		charVariable = (char) shortVariable;
		
		// 배열 
		// 동일한 데이터 타입의 변수 여러개를 담을 수 있는 컨테이너
		// 배열은 길이가 고정 되어 있다
		// 배열은 생성을 해야 사용할 수 있다, new 연산자를 사용하여 생성
		// 실제 데이터가 저장되는 것이 아니라 데이터 배열이 저장된 첫번째 요소의 주소가 저장
		
		// 배열 선언
		// 데이터타입[] 배열명;
		int[] scores;
		
		// 배열 생성
		// 배열명 = new 데이터타입[배열의 길이];
		scores = new int[3];
		System.out.println(scores);
		
		// 배열 선언시 초기값 지정
		int[] numbers = {1, 2, 3};
		int[] ages = new int[] {15, 18, 21, 24};
		
		System.out.println(numbers);
		
		// 인덱스를 이용한 배열 요소 접근
		// 배열은 0번부터 시작하는 각 요소에 인덱스가 존재함
		// 해당 인덱스로 각 요소에 접근할 수 있음
		System.out.println(numbers[0]);
		numbers[0] = 10;
		System.out.println(numbers[0]);
		
		// numbers[3] = 99;
		
		// 배열의 길이
		// 배열명.length;
		System.out.println(numbers.length);
		numbers[numbers.length - 1] = 99;
		
		// 문자열
		char[] string = new char[10];
		string[0] = 'H';
		string[1] = 'e';
		string[2] = 'l';
		string[3] = 'l';
		string[4] = 'o';
		
		string[0] = 'H';
		string[1] = 'e';
		string[2] = 'l';
		string[3] = 'l';
		string[4] = '!';
		
		System.out.print(string[0]);
		System.out.print(string[1]);
		System.out.print(string[2]);
		System.out.print(string[3]);
		System.out.println(string[4]);
		
		System.out.println(string);
		
		// String 클래스를 이용한 문자열 사용
		// String 클래스는 문자열 배열을 개발자가 조금 더 쉽게 사용할 수 있도록
		// 도움을 주는 자바에서 제공해주는 참조형 데이터 타입
		
		// 선언 방법
		// String 변수명;
		String stringVariable;
		
		// 생성 방법
		// 변수명 = new String();
		stringVariable = new String();
		
		// 초기값 지정 방법
		// String 변수명 = "문자열";
		// String 변수명 = new String ("문자열");
		String name = "이지훈";
		String address = new String("부산광역시");
		
		System.out.println(name);
		System.out.println(address);
		
		name = "홍길동";
		
		
		
		// String 참조 타입의 포함기능
		String longComment1 = "내가 그린 기린 그림은 잘 그린 기린 그림이고 ";
		String longComment2 = "네가 그린 기린 그림은 잘 못 그린 기린 그림이다.";
		
		// 문자열 결합 : + 연산자나 concat(문자열변수); 기능을 사용
		String longComment = longComment1 + longComment2;
		System.out.println(longComment);
		
		// 문자열 비교 : equals(문자열변수); 기능을 사용
		boolean isEqual = longComment1.equals(longComment2);
		System.out.println(isEqual);
		
		// 문자열 길이 : length(); 기능을 사용
		int commentLength = longComment.length();
		
		System.out.println(commentLength);
		
		// 문자 찾기 : indexOf(문자열변수); 기능을 사용
		int findedIndex = longComment.indexOf("기린", 7);
		System.out.println(findedIndex);
		
		// 문자 자르기 : substring(시작인덱스, 끝인덱스); 기능을 사용
		String painting = longComment.substring(3, 8);
		System.out.println(painting);
		
		// 문자열 변환 
		// 모든 문자를 대문자로 변경: toUpperCase() 기능을 사용
		// 모든 문자를 소문자로 변경: toLowerCase() 기능을 사용
		// 문자열의 맨 앞 뒤의 공백 제거 : trim() 기능을 사용
		
		// 참조형 데이터 타입의  null
		// 참조형 데이터 타입의 변수의 경우는 그 무엇도 참조하지 않는다는
		// 'null' 값을 가질 수 있음
		stringVariable = null;
		System.out.println(stringVariable);
		
		// null을 가지고 있는 참조 변수는 사용할 수 없음
		// stringVariable.equals("안녕");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
