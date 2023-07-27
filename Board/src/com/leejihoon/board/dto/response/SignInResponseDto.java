package com.leejihoon.board.dto.response;

import com.leejihoon.board.entity.User;

public class SignInResponseDto {
	

	private String email;
	private String nickname;
	private String profileImage;
	
	public SignInResponseDto(User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.profileImage = user.getProfileImage();
	}

	@Override
	public String toString() {
		return "[email=" + email + ", nickname=" + nickname + ", profileImage=" + profileImage + "]";
	}
	
	
	
	
}
