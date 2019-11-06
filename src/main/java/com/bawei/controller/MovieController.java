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
	 * 查询
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
	 * 修改
	 * @param vo
	 * @return
	 */
	@RequestMapping("update")
	public String update(Vo vo) {
		if(vo.getType().equals("下架")) {
			vo.setType("正在热映");
		}
		else if(vo.getType().equals("正在热映")) {
			vo.setType("上架");
		}else if(vo.getType().equals("上架")) {
			vo.setType("下架");
		}
		service.update(vo);
		return "redirect:list";
	}
	/**
	 * 删除
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
