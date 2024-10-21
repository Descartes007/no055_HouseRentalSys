package com.dao;

import com.entity.FangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangzhuVO;
import com.entity.view.FangzhuView;


/**
 * 房主
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface FangzhuDao extends BaseMapper<FangzhuEntity> {
	
	List<FangzhuVO> selectListVO(@Param("ew") Wrapper<FangzhuEntity> wrapper);
	
	FangzhuVO selectVO(@Param("ew") Wrapper<FangzhuEntity> wrapper);
	
	List<FangzhuView> selectListView(@Param("ew") Wrapper<FangzhuEntity> wrapper);

	List<FangzhuView> selectListView(Pagination page,@Param("ew") Wrapper<FangzhuEntity> wrapper);
	
	FangzhuView selectView(@Param("ew") Wrapper<FangzhuEntity> wrapper);
	
}
