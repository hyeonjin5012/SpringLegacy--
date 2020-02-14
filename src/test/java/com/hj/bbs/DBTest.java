package com.hj.bbs;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hj.bbs.dto.BoardVO;
import com.hj.bbs.dto.Criteria;
import com.hj.bbs.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBTest {
	@Inject
	private SqlSessionFactory sqlFactory;

	@Inject
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		List<BoardVO> lists = mapper.getList();
		for (BoardVO list : lists) {
			System.out.println(list.getTitle());
		}
	}

	@Test
	public void testoracleList() {
		Criteria cri = new Criteria();
		List<BoardVO> lists = mapper.oracleListPaging(cri);
		for (BoardVO list : lists) {
			System.out.println(list.getTitle());
		}
	}

	@Test
	public void testTotalCount() {
		Criteria cri = new Criteria();
		System.out.println(mapper.totalCount(cri));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("타이틀");
		board.setContent("컨텐트");
		board.setWriter("guswls");
		int result = mapper.insert(board);
		System.out.println(result);
	}

	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2);
		board.setTitle("타");
		board.setContent("컨텐트");
		board.setWriter("guswls");
		int result = mapper.update(board);
		System.out.println(result);
	}

	@Test
	public void testFactory() {
		System.out.println(">>> sqlFactory : " + sqlFactory);
	}

	@Test
	public void testSession() throws Exception {
		try (SqlSession session = sqlFactory.openSession()) {
			System.out.println(">>> session : " + session + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
