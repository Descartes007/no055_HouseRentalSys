package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WoyaodangfangzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WoyaodangfangzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WoyaodangfangzhuView;


/**
 * 我要当房主
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface WoyaodangfangzhuService extends IService<WoyaodangfangzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WoyaodangfangzhuVO> selectListVO(Wrapper<WoyaodangfangzhuEntity> wrapper);
   	
   	WoyaodangfangzhuVO selectVO(@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);
   	
   	List<WoyaodangfangzhuView> selectListView(Wrapper<WoyaodangfangzhuEntity> wrapper);
   	
   	WoyaodangfangzhuView selectView(@Param("ew") Wrapper<WoyaodangfangzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WoyaodangfangzhuEntity> wrapper);
   	
}

