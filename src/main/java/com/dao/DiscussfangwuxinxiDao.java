package com.dao;

import com.entity.DiscussfangwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfangwuxinxiVO;
import com.entity.view.DiscussfangwuxinxiView;


/**
 * 房屋信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface DiscussfangwuxinxiDao extends BaseMapper<DiscussfangwuxinxiEntity> {
	
	List<DiscussfangwuxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
	
	DiscussfangwuxinxiVO selectVO(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
	
	List<DiscussfangwuxinxiView> selectListView(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);

	List<DiscussfangwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
	
	DiscussfangwuxinxiView selectView(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
	
}
