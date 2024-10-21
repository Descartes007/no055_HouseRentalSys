package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HetongxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HetongxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HetongxinxiView;


/**
 * 合同信息
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HetongxinxiService extends IService<HetongxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HetongxinxiVO> selectListVO(Wrapper<HetongxinxiEntity> wrapper);
   	
   	HetongxinxiVO selectVO(@Param("ew") Wrapper<HetongxinxiEntity> wrapper);
   	
   	List<HetongxinxiView> selectListView(Wrapper<HetongxinxiEntity> wrapper);
   	
   	HetongxinxiView selectView(@Param("ew") Wrapper<HetongxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HetongxinxiEntity> wrapper);
   	
}

