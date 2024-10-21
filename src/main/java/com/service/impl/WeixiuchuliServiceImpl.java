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


import com.dao.WeixiuchuliDao;
import com.entity.WeixiuchuliEntity;
import com.service.WeixiuchuliService;
import com.entity.vo.WeixiuchuliVO;
import com.entity.view.WeixiuchuliView;

@Service("weixiuchuliService")
public class WeixiuchuliServiceImpl extends ServiceImpl<WeixiuchuliDao, WeixiuchuliEntity> implements WeixiuchuliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiuchuliEntity> page = this.selectPage(
                new Query<WeixiuchuliEntity>(params).getPage(),
                new EntityWrapper<WeixiuchuliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiuchuliEntity> wrapper) {
		  Page<WeixiuchuliView> page =new Query<WeixiuchuliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiuchuliVO> selectListVO(Wrapper<WeixiuchuliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiuchuliVO selectVO(Wrapper<WeixiuchuliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiuchuliView> selectListView(Wrapper<WeixiuchuliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiuchuliView selectView(Wrapper<WeixiuchuliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
