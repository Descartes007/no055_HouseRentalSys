package com.dao;

import com.entity.DiscusswoyaodangfangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusswoyaodangfangzhuVO;
import com.entity.view.DiscusswoyaodangfangzhuView;


/**
 * 我要当房主评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface DiscusswoyaodangfangzhuDao extends BaseMapper<DiscusswoyaodangfangzhuEntity> {
	
	List<DiscusswoyaodangfangzhuVO> selectListVO(@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
	
	DiscusswoyaodangfangzhuVO selectVO(@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
	
	List<DiscusswoyaodangfangzhuView> selectListView(@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);

	List<DiscusswoyaodangfangzhuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
	
	DiscusswoyaodangfangzhuView selectView(@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
	
}
