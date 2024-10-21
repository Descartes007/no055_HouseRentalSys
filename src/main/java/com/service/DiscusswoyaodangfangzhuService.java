package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswoyaodangfangzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswoyaodangfangzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswoyaodangfangzhuView;


/**
 * 我要当房主评论表
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface DiscusswoyaodangfangzhuService extends IService<DiscusswoyaodangfangzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswoyaodangfangzhuVO> selectListVO(Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
   	
   	DiscusswoyaodangfangzhuVO selectVO(@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
   	
   	List<DiscusswoyaodangfangzhuView> selectListView(Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
   	
   	DiscusswoyaodangfangzhuView selectView(@Param("ew") Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswoyaodangfangzhuEntity> wrapper);
   	
}

