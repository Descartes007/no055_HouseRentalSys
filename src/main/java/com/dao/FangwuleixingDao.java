package com.dao;

import com.entity.FangwuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwuleixingVO;
import com.entity.view.FangwuleixingView;


/**
 * 房屋类型
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface FangwuleixingDao extends BaseMapper<FangwuleixingEntity> {
	
	List<FangwuleixingVO> selectListVO(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
	
	FangwuleixingVO selectVO(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
	
	List<FangwuleixingView> selectListView(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);

	List<FangwuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
	
	FangwuleixingView selectView(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
	
}
