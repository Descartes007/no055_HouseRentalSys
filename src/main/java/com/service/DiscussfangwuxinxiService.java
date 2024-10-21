package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfangwuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfangwuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfangwuxinxiView;


/**
 * 房屋信息评论表
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface DiscussfangwuxinxiService extends IService<DiscussfangwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangwuxinxiVO> selectListVO(Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
   	DiscussfangwuxinxiVO selectVO(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
   	List<DiscussfangwuxinxiView> selectListView(Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
   	DiscussfangwuxinxiView selectView(@Param("ew") Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangwuxinxiEntity> wrapper);
   	
}

