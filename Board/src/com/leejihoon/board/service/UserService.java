package com.leejihoon.board.service;

import com.leejihoon.board.dto.request.SignInRequestDto;
import com.leejihoon.board.dto.request.SignUpRequestDto;
import com.leejihoon.board.dto.response.ResponseEntity;
import com.leejihoon.board.dto.response.SignInResponseDto;
import com.leejihoon.board.dto.response.SignUpResponseDto;

public interface UserService {
	
	ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto);
	ResponseEntity<SignInResponseDto> signIn(SignInRequestDto dto);
	
}
