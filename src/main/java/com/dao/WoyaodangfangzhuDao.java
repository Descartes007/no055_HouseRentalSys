package com.dao;

import com.entity.WoyaodangfangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WoyaodangfangzhuVO;
import com.entity.view.WoyaodangfangzhuView;


/**
 * 我要当房主
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface WoyaodangfangzhuDao extends BaseMapper<WoyaodangfangzhuEntity> {
	
	List<WoyaodangfangzhuVO> selectListVO(@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);
	
	WoyaodangfangzhuVO selectVO(@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);
	
	List<WoyaodangfangzhuView> selectListView(@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);

	List<WoyaodangfangzhuView> selectListView(Pagination page,@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);
	
	WoyaodangfangzhuView selectView(@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);
	
}
