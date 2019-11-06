package com.bawei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.dao.MovieMapper;
import com.bawei.domain.Movie;
import com.bawei.uitls.Vo;

@Service
public class MovieService {
	@Autowired
	private MovieMapper mapper;
/**
 * ²éÑ¯
 * @param vo
 * @return
 */
	public List<Movie> list(Vo vo) {
		return mapper.list(vo);
				
	}
/**
 * ÐÞ¸Ä
 * @param vo
 */
	public void update(Vo vo) {
		mapper.update(vo);
		
	}
/**
 * É¾³ý
 * @param mids
 */
	public void delet(Integer[] mids) {
		mapper.delet(mids);
		
	}
	
}
