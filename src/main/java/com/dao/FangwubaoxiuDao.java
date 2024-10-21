package com.dao;

import com.entity.FangwubaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwubaoxiuVO;
import com.entity.view.FangwubaoxiuView;


/**
 * 房屋报修
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface FangwubaoxiuDao extends BaseMapper<FangwubaoxiuEntity> {
	
	List<FangwubaoxiuVO> selectListVO(@Param("ew") Wrapper<FangwubaoxiuEntity> wrapper);
	
	FangwubaoxiuVO selectVO(@Param("ew") Wrapper<FangwubaoxiuEntity> wrapper);
	
	List<FangwubaoxiuView> selectListView(@Param("ew") Wrapper<FangwubaoxiuEntity> wrapper);

	List<FangwubaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<FangwubaoxiuEntity> wrapper);
	
	FangwubaoxiuView selectView(@Param("ew") Wrapper<FangwubaoxiuEntity> wrapper);
	
}
