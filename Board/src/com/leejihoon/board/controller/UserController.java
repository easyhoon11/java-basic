package com.leejihoon.board.controller;

import com.leejihoon.board.dto.request.SignInRequestDto;
import com.leejihoon.board.dto.request.SignUpRequestDto;
import com.leejihoon.board.dto.response.ResponseEntity;
import com.leejihoon.board.dto.response.SignInResponseDto;
import com.leejihoon.board.dto.response.SignUpResponseDto;

public interface UserController {
	
	ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto requestDto);
	ResponseEntity<SignInResponseDto> signIn(SignInRequestDto requestDto);
}

// ResponseDto : int status, String message
// SignUpResponseDto : int status, String message, String email, String nickname, String profileImage