package com.hj.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hj.bbs.dto.BoardVO;
import com.hj.bbs.dto.Criteria;
import com.hj.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> selectAll(Criteria cri) {
		return mapper.oracleListPaging(cri);
	}

	@Override
	public void insert(BoardVO board) {
		mapper.insert(board);
	}

	@Override
	public BoardVO selectOne(int bno) {
		mapper.updateReadCount(bno);
		return mapper.read(bno);
	}

	@Override
	public void update(BoardVO board) {
		mapper.update(board);
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

	@Override
	public int totalCount(Criteria cri) {
		return mapper.totalCount(cri);//레코드 갯수 가져오는
	}

}
