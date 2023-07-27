package com.leejihoon.board.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.leejihoon.board.common.BoardIndex;

// 게시물 번호 / 제목 / 내용 / 작성일 / [작성자 이메일] / 작성자 닉네임 / 작성자 프로필 사진
// 댓글 수 / 좋아요 수 / 조회 수 / 게시물 이미지(여러개) /
// 좋아요한 사용자의 프로필 사진 / 좋아요 한 사용자의 닉네임 / [좋아요한 사용자 이메일]
// 댓글 작성 시간 / 댓글 작성자의 닉네임 / 댓글작성자의 프로필 사진 / 댓글내용 

public class Board {

	private int boardNumber;
	private String title;
	private String contents;
	private String writeDateTime;
	private String writeEmail;
	private String writeNickname;
	private String writeProfileImage;
	private int viewCount;
	private List<String> imageList;
	private List<Likey> likeList;
	private List<Comment> commentList;
	
	public Board(String title, String contents, String writeEmail, String writeNickname, String writeProfileImage,
			List<String> imageList) {
		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd. hh:mm:ss");
		
		this.boardNumber = BoardIndex.index++;
		this.title = title;
		this.contents = contents;
		this.writeDateTime = simpleDateFormat.format(now);
		this.writeEmail = writeEmail;
		this.writeNickname = writeNickname;
		this.writeProfileImage = writeProfileImage;
		this.viewCount = 0;
		this.imageList = imageList;
		this.likeList = new ArrayList<Likey>();
		this.commentList = new ArrayList<Comment>();
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriteNickname() {
		return writeNickname;
	}

	public void setWriteNickname(String writeNickname) {
		this.writeNickname = writeNickname;
	}

	public String getWriteProfileImage() {
		return writeProfileImage;
	}

	public void setWriteProfileImage(String writeProfileImage) {
		this.writeProfileImage = writeProfileImage;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public String getWriteDateTime() {
		return writeDateTime;
	}

	public String getWriteEmail() {
		return writeEmail;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public List<Likey> getLikeList() {
		return likeList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}
	
	
	
	
	
	
}
