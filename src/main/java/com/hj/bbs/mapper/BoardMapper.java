package com.hj.bbs.mapper;

import java.util.List;

import com.hj.bbs.dto.BoardVO;
import com.hj.bbs.dto.Criteria;

public interface BoardMapper {
	
	List<BoardVO> getList();
	int insert(BoardVO board);
	void insertSelectKey(BoardVO board);
	BoardVO read(int bno);
	void delete(int bno);
	int update(BoardVO board);
	void updateReadCount(int bno);
	List<BoardVO> oracleListPaging(Criteria cri);
	List<BoardVO> mysqlListPaging(Criteria cri);
	int totalCount(Criteria cri);
	
}
