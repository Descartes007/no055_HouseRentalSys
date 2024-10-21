package com.dao;

import com.entity.FangwupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwupingjiaVO;
import com.entity.view.FangwupingjiaView;


/**
 * 房屋评价
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface FangwupingjiaDao extends BaseMapper<FangwupingjiaEntity> {
	
	List<FangwupingjiaVO> selectListVO(@Param("ew") Wrapper<FangwupingjiaEntity> wrapper);
	
	FangwupingjiaVO selectVO(@Param("ew") Wrapper<FangwupingjiaEntity> wrapper);
	
	List<FangwupingjiaView> selectListView(@Param("ew") Wrapper<FangwupingjiaEntity> wrapper);

	List<FangwupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<FangwupingjiaEntity> wrapper);
	
	FangwupingjiaView selectView(@Param("ew") Wrapper<FangwupingjiaEntity> wrapper);
	
}
