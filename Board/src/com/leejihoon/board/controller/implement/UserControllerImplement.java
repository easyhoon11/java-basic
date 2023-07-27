package com.leejihoon.board.controller.implement;

import com.leejihoon.board.controller.UserController;
import com.leejihoon.board.dto.request.SignInRequestDto;
import com.leejihoon.board.dto.request.SignUpRequestDto;
import com.leejihoon.board.dto.response.ResponseEntity;
import com.leejihoon.board.dto.response.SignInResponseDto;
import com.leejihoon.board.dto.response.SignUpResponseDto;
import com.leejihoon.board.service.UserService;
import com.leejihoon.board.service.implement.UserServiceImplement;

public class UserControllerImplement implements UserController {
	
	private final UserService userService;
	
	public UserControllerImplement(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto requestDto) {
		
		boolean isVaild = requestDto.valid();
		if(!isVaild) return ResponseEntity.badRequest();
		
		ResponseEntity<SignUpResponseDto> result = userService.signUp(requestDto);
		return result;
	}

	@Override
	public ResponseEntity<SignInResponseDto> signIn(SignInRequestDto requestDto) {
		boolean isValid = requestDto.valid();
		if (!isValid) return ResponseEntity.badRequest();
		
		ResponseEntity<SignInResponseDto> result = userService.signIn(requestDto);
		
		return result;
	}
}
