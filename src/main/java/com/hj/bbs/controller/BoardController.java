package com.hj.bbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hj.bbs.dto.BoardVO;
import com.hj.bbs.dto.Criteria;
import com.hj.bbs.dto.PageMaker;
import com.hj.bbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("cri") Criteria cri, Model model) {//자동으로 criteria가 생성되서 디폴트 1,10이 들어가 있다.	
		int totalCount=service.totalCount(cri);
		PageMaker pageMarker=new PageMaker();
		pageMarker.setCri(cri);
		pageMarker.setTotalCount(totalCount);
		
		model.addAttribute("pageMaker",pageMarker);
		model.addAttribute("list", service.selectAll(cri));
		return "list";
	}
	@GetMapping("/input")
	public String insert() {
		return "input";
	}
	@PostMapping("/input")
	public String insert(@ModelAttribute("board") BoardVO board) {
		service.insert(board);
		return "redirect:list";
	}
	@GetMapping("/update")
	public String update(@ModelAttribute("cri") Criteria cri,@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", service.selectOne(bno));
		return "update";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute("board") BoardVO board,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		service.update(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("type",cri.getType());//왔다갔다 페이지할때는 없었으면 좋겠다할때 플래시 사용->일회성
		rttr.addFlashAttribute("keyword",cri.getKeyword());
		
		return "redirect:list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		service.delete(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("type",cri.getType());//왔다갔다 페이지할때는 없었으면 좋겠다할때 플래시 사용->일회성
		rttr.addFlashAttribute("keyword",cri.getKeyword());
		
		return "redirect:list";
	}

}
