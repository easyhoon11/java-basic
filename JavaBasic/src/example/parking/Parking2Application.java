package example.parking;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

// 주차장 관리 프로그램

// 여유 공간 확인
// 입차 등록
// 주차 확인
// 출차

// 데이터
// 차량번호, 차종, 주차공간, 층수, 입차 시간, 출차 시간, 요금

// 층수 10층, 층 당 30대, 경차: 1000, 중대형 : 1500, SUV: 2000

// 장애인(임산부, 노약자, 유공자), 차량높이, 장기주차, 전기차, 주차시간당 할인, 제휴할인

class ParkingSpace{						// 차량번호, 차종, 입차 시간 관리에 필요한 클래스 생성
	String registerNumber;
	int getInTime;
	String type;
	
	ParkingSpace(String registerNumber, int getInTime, String type) {
		this.registerNumber = registerNumber;
		this.getInTime = getInTime;
		this.type = type;
	}
}

class EnterCarDto{
	String registerNumber;
	String type;
	int getInTime;
	int layer;
	int space;	
	
	EnterCarDto(String registerNumber, String type, int getInTime, int layer, int space){
		this.registerNumber = registerNumber;
		this.type = type;
		this.getInTime = getInTime;
		this.layer = layer;
		this.space = space;
	}
	
	static EnterCarDto getInstance() {

		EnterCarDto instance = null;
		
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("차량번호 : ");
			String registerNumber = scanner.nextLine();
			
			System.out.print("차종 : ");
			String type = scanner.nextLine();
			
			System.out.print("입차 시간 (0 ~ 24) : ");
			int getInTime = scanner.nextInt();
			
			System.out.print("주차층 (0 ~ 9) : ");
			int layer = scanner.nextInt();
			
			System.out.print("주차 공간 (0 ~ 29) : ");
			int space = scanner.nextInt();
			
			// todo : 차량번호 : 빈값인지 아닌지
			if(registerNumber.isBlank()) {
				System.out.println("차량 번호를 반드시 입려하세요");
				return instance;
			}
			// todo : 사용자 입력 검증
			if(registerNumber == null || type == null) {
				System.out.println("입력 오류 입니다.");
				return instance;
			}
			// todo : 차종 : 경차, 중대형, SUV
			boolean validType = type.equals("경차") || type.equals("중대형") || type.equals("SUV");
			if(!validType) {
				System.out.println("경차, 중대형, SUV 중에 하나를 입력하세요.");
				return instance;
			}
			// todo : 입차시간 : 0 ~ 24 사이 인지
			if(getInTime < 0 || getInTime > 24) {
				System.out.println("입차시간(0 ~ 24)을 정확히 입력하세요.");
				return instance;
			}
			// todo : 주차층 : 0 ~ 9 사이 인지
			if(layer < 0 || layer > 9) {
				System.out.println("주차층(0 ~ 9)을 정확히 입력하세요.");
				return instance;
			}
			// todo : 주차공간 : 0 ~ 29 사이 인지
			if(space < 0 || space > 29) {
				System.out.println("주차공간(0 ~ 29)을 정확히 입력하세요.");
				return instance;
			}
			instance = new EnterCarDto(registerNumber, type, getInTime, layer, space);
		} catch(Exception exception) {
			System.out.println("입력 오류 입니다.");
		}
		return instance;
	}
}

class FindCarDto {
	int floor;
	int space;
	
	FindCarDto(int floor, int space){
		this.floor = floor;
		this.space = space;
	}
	
}

public class Parking2Application {						// 차종별 주차요금과 주차공간배열 관리하는 클래스
	
	static final int LIGHT_FARE = 1000;
	static final int HEAVY_FARE = 1500;
	static final int SUV_FARE = 2000;
			
	static final ParkingSpace[][] PARKING_SPACES = new ParkingSpace[10][30];
			
	public static void main(String[] args) {
				
		while(true) {
			
			// -1 : 잘못된 값 / 0~5 : 정상
			int selectedMethod = input();				// input에서 받은값을 selectedMethod에 넣음
			if (selectedMethod == -1) continue;			// selectedMethod가 -1일 경우 다시 input값 가져옴
			
			if (selectedMethod == 0) {					// selectedMethod가 0일 경우 종료
				System.out.println("프로그램 종료");
				break;
			}
			if(selectedMethod == 1) getAllFreeSpace();
			if(selectedMethod == 2) getFloorFreeSpace ();
			if(selectedMethod == 3) enterCar();
			if(selectedMethod == 4) checkParking();
			if(selectedMethod == 5) outCar();
		}
	}
	static int input() {							// input메서드 생성
		Scanner scanner = new Scanner(System.in);	// 스캐너 호출
		
		System.out.println("작업을 선택하세요. \n1. 전체 주차공간 확인\n2. 층별 주차공간 확인 \n3. 입차 \n4. 차량확인 \n5. 출차 \n0. 종료");	// 입력받을 메세지
		
		int selectedMethod = -1;	// selectdeMethod 를 int로 선언 초기값 -1지정(0은 입력받을수도 있기때문에)
		
		try {										  // 예외 상황 처리			
			selectedMethod = scanner.nextInt();		  // selectdeMethod에 0~5 입력받음	
		} catch (Exception exception) {				  // 예외 상황 발생시 
			System.out.println("숫자만 입력해주세요"); 	  // 예외 상황 발생시 메세지
			return -1;								  // 초기값 -1로 다시 반환
		}
		
		boolean validInput = selectedMethod < 0 || selectedMethod > 5; 	// validInput 을 boolean으로 선언 후 초기값 selectedMethod이 0~5 아닐경우 트루 
		if (validInput) {					// validInput가 트루면 
			System.out.println("잘못된 입력입니다."); 
			return -1;						// 초기값 -1 로 반환
		}
		return selectedMethod;				// 입력받은 값으로 리턴
	}
	
	static void getAllFreeSpace() { 				// 전체 여유공간 출력
		
		int sum = 0;										// 전체 여유공간 저장할 sum변수 선언
		for(ParkingSpace[] floor : PARKING_SPACES) {		// for-each 반복문 통해 30번째줄 배열의 첫번째 []를 floor로 불러옴
			for(ParkingSpace space : floor) {				// for-each 반복문 통해 30번째줄 배열의 두번째 []를 space로 불러옴
				if(space == null) sum++;					// space가 null이면 sum의 숫자를 추가함
			}
		}
		System.out.println("전체 여유 공간 : " + sum);
	}
	
	static void getFloorFreeSpace () {				// 층별 여유공간 출력
		
		int[] freeSpaces = new int[10];												// 층별 여유공간 저장할 freeSpaces 배열[10] 생성
						
		for(int layer = 0; layer < PARKING_SPACES.length; layer++) {				
			for(ParkingSpace space : PARKING_SPACES[layer]) {
				if(space == null) freeSpaces[layer]++;
			}
		}
		for(int layer = 0; layer < freeSpaces.length; layer++) {
			System.out.println(layer + 1 + "층의 여유 공간 : " + freeSpaces[layer]);
		}
	}
	
	static void enterCar() {						// 입차 처리
		// todo : 사용자로부터 입력 (차량번호, 차종, 입차시간, 주차층, 주차공간)
//		String registerNumber = null;
//		String type = null;
//		int getInTime = -1;
//		int layer = -1;
//		int space = -1;					위 Dto클래스로 이동
		
		EnterCarDto dto = EnterCarDto.getInstance();
		if (dto == null) return;
//		try {
//			Scanner scanner = new Scanner(System.in);
//			
//			System.out.print("차량번호 : ");
//			dto.registerNumber = scanner.nextLine();
//			
//			System.out.print("차종 : ");
//			dto.type = scanner.nextLine();
//			
//			System.out.print("입차 시간 (0 ~ 24) : ");
//			dto.getInTime = scanner.nextInt();
//			
//			System.out.print("주차층 (0 ~ 9) : ");
//			dto.layer = scanner.nextInt();
//			
//			System.out.print("주차 공간 (0 ~ 29) : ");
//			dto.space = scanner.nextInt();
//			
//		} catch(Exception exception) {
//			System.out.println("입력 오류 입니다.");
//			return;
//		}
		

		
		
		// todo : 해당 공간이 비어있는지
		if(PARKING_SPACES[dto.layer][dto.space] != null) {
			System.out.println("이미 주차된 공간입니다.");
			return;
		}
		// todo : 입차 처리
		PARKING_SPACES[dto.layer][dto.space] = new ParkingSpace(dto.registerNumber, dto.getInTime, dto.type);
		
//		ParkingSpace parkingSpace = new ParkingSpace(registerNumber, getInTime, type)
//		parkingSpace.registerNumber = registerNumber;
//		parkingSpace.type = type;
//		parkingSpace.getInTime = getInTime;		
//		PARKING_SPACES[layer][space] = parkingSpace;				이 5줄이 위 한줄로 줄여짐(new 한번에함)
	}
	
	static void checkParking() {
		// todo : 주차 확인
		Scanner scanner = new Scanner(System.in);
		System.out.println("확인할 차량번호를 입력하세요.");
		String registerNumber = scanner.nextLine();
		
		// 입력 검증 (null)
		if (registerNumber == null) {
			System.out.println("입력 오류 입니다.");
			return;
		} 
		// 입력 검증 (공백)
		if (registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력해주세요.");
			return;
		}
		
		FindCarDto findCarDto = findCar(registerNumber);
		
		
		if (findCarDto == null) {
			System.out.println("찾을 수 없는 차량 번호입니다.");
			return;
		}else System.out.println(findCarDto.floor + "층 " + findCarDto.space + "번에 위치합니다.");
	}
	
	static void outCar() {
		// todo : 출차 처리
		String registerNumber = null;
		int outTime	= -1;	
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("차량번호 : ");
			registerNumber = scanner.nextLine();
			System.out.println("출차 시간 (0 ~ 24) : ");
			outTime = scanner.nextInt();
		} catch(Exception exception) {
			System.out.println("입력 오류 입니다.");
		    return;
		}
		if (registerNumber == null) {
			System.out.println("입력 오류 입니다.");
			return;
		}
		if (registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력해주세요.");
			return;
		}
		if(outTime < 0 || outTime > 24) {
			System.out.println("출차 시간은 0 ~ 24 사이어야 합니다.");
			return;
		}
		
		FindCarDto findCarDto = findCar(registerNumber);
		
		if (findCarDto == null) {
			System.out.println("찾을 수 없는 차량 번호 입니다.");
			return;
		}
		
		ParkingSpace parkingSpace = PARKING_SPACES[findCarDto.floor][findCarDto.space];
		if(parkingSpace.getInTime < outTime) {
			System.out.println("출차 시간이 입차 시간보다 작을 수 없습니다.");
			return;
		}
		int typePayment = parkingSpace.type.equals("경차") ? LIGHT_FARE :
						  parkingSpace.type.equals("중대형") ? HEAVY_FARE : SUV_FARE;
		int payment = (outTime - parkingSpace.getInTime) * typePayment;
		
		System.out.println("주차요금은 " + payment + "원 입니다.");
		
		PARKING_SPACES[findCarDto.floor][findCarDto.space] = null;
	}
	
	static FindCarDto findCar(String registerNumber) {
		
		FindCarDto dto = null;

		// 차량 넘버가 있는 주차층 찾는 반복문
		for (int floor = 0; floor < PARKING_SPACES.length; floor++) {
			for (int space = 0; space < PARKING_SPACES[floor].length; space++) {
						
				if (PARKING_SPACES[floor][space] == null) continue;
						
				if(registerNumber.equals(PARKING_SPACES[floor][space].registerNumber)) {
					dto = new FindCarDto(floor, space);
					break;
				}
			}
			if (dto != null) break;
		}
		return dto;
	}	
}
