package com.hj.bbs.service;

import java.util.List;

import com.hj.bbs.dto.BoardVO;
import com.hj.bbs.dto.Criteria;

public interface BoardService {

	public List<BoardVO> selectAll(Criteria cri);
	public void insert(BoardVO board);
	public BoardVO selectOne(int bno);
	public void update(BoardVO board);
	public void delete(int bno);
	public int totalCount(Criteria cri);

}
