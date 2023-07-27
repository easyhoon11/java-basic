package com.leejihoon.board.service.implement;

import com.leejihoon.board.common.ResponseMessage;
import com.leejihoon.board.dto.request.SignInRequestDto;
import com.leejihoon.board.dto.request.SignUpRequestDto;
import com.leejihoon.board.dto.response.ResponseEntity;
import com.leejihoon.board.dto.response.SignInResponseDto;
import com.leejihoon.board.dto.response.SignUpResponseDto;
import com.leejihoon.board.entity.User;
import com.leejihoon.board.repository.UserRepository;
import com.leejihoon.board.repository.implement.UserRepositoryImplement;
import com.leejihoon.board.service.UserService;

public class UserServiceImplement implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	
	@Override
	public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto) {
		
		String email = dto.getEmail();
		String telNumber = dto.getTelNumber();
		String nickname = dto.getNickName();
		
		// 이메일 중복 확인
		boolean hasEmail = userRepository.existsByEmail(email);
		if (hasEmail) return ResponseEntity.badRequest(ResponseMessage.EXISTED_EMAIL);
		
		// 전화번호 중복 확인
		boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
		if (hasTelNumber) return ResponseEntity.badRequest(ResponseMessage.EXISTED_TEL_NUMBER);
		
		// 닉네임 중복 확인
		boolean hasNickname = userRepository.existsByNickname(nickname);
		if (hasNickname) return ResponseEntity.badRequest(ResponseMessage.EXISTED_NICKNAME);
		
		// Entity 생성
		User user = new User(dto);
		
		// Entity 저장
		boolean result = userRepository.create(user);
		if (!result) return ResponseEntity.internalServerError(ResponseMessage.DATABASE_ERROR);
		
		return ResponseEntity.ok();
	}


	@Override
	public ResponseEntity<SignInResponseDto> signIn(SignInRequestDto dto) {
		
		String email = dto.getEmail();
		String password = dto.getPassword();
		
		// 이메일로 유저 정보 찾기
		User user = userRepository.read(email);
		if (user == null) return ResponseEntity.unauthorzed();
		
		// 입력한 비밀번호가 저장된 비밀번호와 같은지 비교 
		if(!password.equals(user.getPassword())) return ResponseEntity.unauthorzed();
		
		SignInResponseDto data = new SignInResponseDto(user);
		
		return ResponseEntity.ok(data);
	}

}
