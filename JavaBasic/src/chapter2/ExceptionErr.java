package chapter2;


import java.util.Scanner;



public class ExceptionErr {

	public static void main(String[] args) {
		
		// 예외 : 프로그램 실행중에 발생할 수 있는 예상치 못한 상황
		// 외부에서 데이터를 받아오거나 혹은 사용자의 조작이 포함되어있을 때 발생
		Scanner scanner = new Scanner(System.in);
		
//		// InputMismatchException 발생 가능 (정수가 아닌 값이 입력 될 수 있음
//		int number = scanner.nextInt();
//		System.out.println(number);
		
		// ArrayIndexOutOfBoundsException 발생가능 (인덱스를 벗어난 값이 입력 될 수 있음)
//		int[] numbers = new int[3];
//		numbers[number] = 10;
//		System.out.println(numbers[number]);
		
		// ArithmeticException 발생 가능 (0이 입력되어 0으로 나누는 상황이 발생할 수 있음)
//		int result = 10 / number;
//		System.out.println(result);
		
		// 예외 처리 방법
		// try { 예외 발생할 수 있는 코드 } 
		// catch(예외 클래스 매개변수명){ 예외가 발생했을 때 실행할 코드 }
		// ...
		
		try {
			int number = scanner.nextInt();
			System.out.println(number);
			
			int[] numbers = new int[3];
			numbers[number] = 10;
		} catch(Exception exception) {
			System.out.println("다시 입력해주세요");
		}
			
			
//		} catch (InputMismatchException exception) {
//			System.out.println("정수만 입력할 수 있습니다.");
//		} catch (ArrayIndexOutOfBoundsException exception) {
//			System.out.println("인덱스 범위를 초과했습니다.");
//		}
		System.out.println("프로그램 정상 종료");
		
		
		
		
		
		
		
		
		
	}

}
