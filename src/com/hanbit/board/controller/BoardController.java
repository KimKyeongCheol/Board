package com.hanbit.board.controller;


import javax.swing.JOptionPane;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.hanbit.board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args){
	BoardBean board=null;
	BoardService bService=new BoardServiceImpl();
	
	while(true){
		switch (JOptionPane.showInputDialog("0.종료 1.글쓰기 2.목록 3.글찾기(작성자) 4.글찾기(글번호) 5.수정 6. 삭제")) {
		case "0":
			return;
		case "1": 
			board=new BoardBean();
			String[] foo=JOptionPane.showInputDialog("글번호/작성자/제목/내용/날짜").split("/");
			board.setSeq(Integer.parseInt(foo[0]));
			board.setWriter(foo[1]);
			board.setTitle(foo[2]);
			board.setContent(foo[3]);
			board.setRegdate(foo[4]);
			bService.writeBoard(board);
			JOptionPane.showMessageDialog(null,"등록되었습니다.");
			
			break;
		case "2":
			JOptionPane.showInputDialog(bService.toString());
			break;
		case "3":
			String writer=JOptionPane.showInputDialog("이름을 검색하세요");
			BoardBean[] bb=bService.findByWriter(writer);
			String result="";
			if(bb.length==0){
				result="조회한 이름이 없습니다.";
			}else {
				for(int i=0;i<bb.length;i++)
				{
					result+=bb[i].toString()+"\n";
				}
			}
			JOptionPane.showConfirmDialog(null, result);
			break;
		case "4":
			board=new BoardBean();
			board=bService.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("조회하려는 아이디를 입력해주세요.")));
			JOptionPane.showMessageDialog(null,board.toString());
			break;
		case "5":
			board=new BoardBean();
			int seqn=Integer.parseInt(JOptionPane.showInputDialog("SEQ 입력"));
			String cont=JOptionPane.showInputDialog("내용변경");
			board.setSeq(seqn);
			board.setContent(cont);
			bService.updateContent(board);
			JOptionPane.showMessageDialog(null, "변경완료");
			break;
		case "6" :
			int se=Integer.parseInt(JOptionPane.showInputDialog("삭제할 번호입력"));
			bService.delete(se);
			JOptionPane.showMessageDialog(null, "삭제완료");
			break;
		}
		}
	}

}
