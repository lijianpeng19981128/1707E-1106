package com.bawei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.domain.Movie;
import com.bawei.service.MovieService;
import com.bawei.uitls.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {
	@Autowired
	private MovieService service;
  
	/**
	 * ��ѯ
	 * @param request
	 * @param pageNum
	 * @param vo
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue = "1") int pageNum,Vo vo) {
		if(""==vo.getMethod() && vo.getMethod().equals(null) ) {
			vo.setMethod("asc");
		}
		PageHelper.startPage(pageNum, 2);
		List<Movie> list = service.list(vo);
		PageInfo<Movie> info = new PageInfo<Movie>(list);
		request.setAttribute("pg", info);
		request.setAttribute("vo", vo);
		return "list";
		
	}
	/**
	 * �޸�
	 * @param vo
	 * @return
	 */
	@RequestMapping("update")
	public String update(Vo vo) {
		if(vo.getType().equals("�¼�")) {
			vo.setType("������ӳ");
		}
		else if(vo.getType().equals("������ӳ")) {
			vo.setType("�ϼ�");
		}else if(vo.getType().equals("�ϼ�")) {
			vo.setType("�¼�");
		}
		service.update(vo);
		return "redirect:list";
	}
	/**
	 * ɾ��
	 * @param mids
	 * @return
	 */
	@RequestMapping("delet")
	@ResponseBody
	public int delet(@RequestParam("mids") Integer mids[]) {
		service.delet(mids);
		return 1;
		
	}
}
