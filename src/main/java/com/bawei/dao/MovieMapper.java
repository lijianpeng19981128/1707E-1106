package com.bawei.dao;

import java.util.List;

import com.bawei.domain.Movie;
import com.bawei.uitls.Vo;

public interface MovieMapper {

	List<Movie> list(Vo vo);

	void update(Vo vo);

	void delet(Integer[] mids);

}
