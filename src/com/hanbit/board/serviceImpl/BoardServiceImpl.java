package com.hanbit.board.serviceImpl;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService {
	BoardBean board;
	BoardBean[] boardList;
	int count=0;
	public BoardServiceImpl(){
		count=0;
		board=new BoardBean();
		boardList=new BoardBean[count];
	}
	@Override
	public BoardBean[] listBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		board=new BoardBean();
		for(int i=0;i<count;i++){
			if(seq==boardList[i].getSeq()){
				board=boardList[i];
				break;
			}
		}
		return board;
		
		
	}

	@Override
	public BoardBean[] findByWriter(String writer) {
		int cnt=0;
		for(int i=0;i<boardList.length;i++){
			if(writer.equals(boardList[i].getWriter())){
				cnt++;
			}
		}
		BoardBean[] find=new BoardBean[cnt];
		int num=0;
		for(int i=0;i<boardList.length;i++){
			if(writer.equals(boardList[i].getWriter())){
				find[num]=boardList[i];
				num++;
			}
			if(cnt==num){
				break;
			}
		}
		return find;
	
	}
	public String toString(){
		String list="";
		for(int i=0;i<count;i++){
			list+=boardList[i].getSeq()+"/ "+boardList[i].getWriter()+"/ "+boardList[i].getTitle()+"/"+boardList[i].getContent()+"/"
		+boardList[i].getRegdate()+"\n";
		}
		return list;
	}


	@Override
	public void updateContent(BoardBean param) {
		board=findBySeq(param.getSeq());
		board.setContent(param.getContent());
		
		
	}

	@Override
	public void delete(int seq) {
		for(int i=0;i<count;i++){
			if(seq==boardList[i].getSeq()){
				boardList[i]=boardList[count-1];
				boardList[count-1]=null;
				break;
			}
		}count--;
		
	}
	@Override
	public void writeBoard(BoardBean board) {
		if(count==boardList.length){
			BoardBean[] temp=new BoardBean[count+1];
			System.arraycopy(boardList,0,temp,0,count);
			boardList=temp;
		
			}
		boardList[count++]=board;
		
	}
	@Override
	public void setCount() {
		count++;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}
	

}
