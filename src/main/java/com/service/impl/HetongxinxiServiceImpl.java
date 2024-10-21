package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.HetongxinxiDao;
import com.entity.HetongxinxiEntity;
import com.service.HetongxinxiService;
import com.entity.vo.HetongxinxiVO;
import com.entity.view.HetongxinxiView;

@Service("hetongxinxiService")
public class HetongxinxiServiceImpl extends ServiceImpl<HetongxinxiDao, HetongxinxiEntity> implements HetongxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HetongxinxiEntity> page = this.selectPage(
                new Query<HetongxinxiEntity>(params).getPage(),
                new EntityWrapper<HetongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HetongxinxiEntity> wrapper) {
		  Page<HetongxinxiView> page =new Query<HetongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HetongxinxiVO> selectListVO(Wrapper<HetongxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HetongxinxiVO selectVO(Wrapper<HetongxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HetongxinxiView> selectListView(Wrapper<HetongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HetongxinxiView selectView(Wrapper<HetongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
