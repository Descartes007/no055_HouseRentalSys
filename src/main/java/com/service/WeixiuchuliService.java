package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiuchuliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiuchuliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiuchuliView;


/**
 * 维修处理
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface WeixiuchuliService extends IService<WeixiuchuliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuchuliVO> selectListVO(Wrapper<WeixiuchuliEntity> wrapper);
   	
   	WeixiuchuliVO selectVO(@Param("ew") Wrapper<WeixiuchuliEntity> wrapper);
   	
   	List<WeixiuchuliView> selectListView(Wrapper<WeixiuchuliEntity> wrapper);
   	
   	WeixiuchuliView selectView(@Param("ew") Wrapper<WeixiuchuliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuchuliEntity> wrapper);
   	
}

