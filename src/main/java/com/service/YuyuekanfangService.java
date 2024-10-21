package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyuekanfangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyuekanfangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuekanfangView;


/**
 * 预约看房
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface YuyuekanfangService extends IService<YuyuekanfangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuekanfangVO> selectListVO(Wrapper<YuyuekanfangEntity> wrapper);
   	
   	YuyuekanfangVO selectVO(@Param("ew") Wrapper<YuyuekanfangEntity> wrapper);
   	
   	List<YuyuekanfangView> selectListView(Wrapper<YuyuekanfangEntity> wrapper);
   	
   	YuyuekanfangView selectView(@Param("ew") Wrapper<YuyuekanfangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuekanfangEntity> wrapper);
   	
}

