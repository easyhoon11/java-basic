package com.leejihoon.board.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leejihoon.board.common.PatternValidator;

//이메일 / 비밀번호 / 비밀번호 확인 / 닉네임 / 휴대전화번호 / 주소 /
//상세주소 / 개인정보동의 여부 

public class SignUpRequestDto {
	
	private String email;
	private String password;
	private String passwordCheck;
	private String nickName;
	private String telNumber;
	private String address;
	private String addressDetail;
	private boolean agreedPersonal;
	
	public SignUpRequestDto() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public boolean isAgreedPersonal() {
		return agreedPersonal;
	}

	public void setAgreedPersonal(boolean agreedPersonal) {
		this.agreedPersonal = agreedPersonal;
	}
	
	public boolean valid() {
		if(email == null || password == null || passwordCheck == null || nickName == null || 
				telNumber == null || address == null || !agreedPersonal) {
			return false;
		}
		
		if (email.isBlank() || password.isBlank() || passwordCheck.isBlank() || nickName.isBlank() ||
				telNumber.isBlank() || address.isBlank()) {
			return false;
		}
		
		if (password.length() < 8) {
			return false;
		}
		
		if (!password.equals(passwordCheck)) {
			return false;
		}
		
		boolean emailCheck = PatternValidator.isValidEmail(email);
		if (!emailCheck) {
			return false;
		}
		
		boolean telNumberCheck = PatternValidator.isValidTelNumber(telNumber);
		if (!telNumberCheck) {
			return false;
		}
		
		return true;
	}
	
	
}
