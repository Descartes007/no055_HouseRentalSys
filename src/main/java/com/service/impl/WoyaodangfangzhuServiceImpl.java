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


import com.dao.WoyaodangfangzhuDao;
import com.entity.WoyaodangfangzhuEntity;
import com.service.WoyaodangfangzhuService;
import com.entity.vo.WoyaodangfangzhuVO;
import com.entity.view.WoyaodangfangzhuView;

@Service("woyaodangfangzhuService")
public class WoyaodangfangzhuServiceImpl extends ServiceImpl<WoyaodangfangzhuDao, WoyaodangfangzhuEntity> implements WoyaodangfangzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WoyaodangfangzhuEntity> page = this.selectPage(
                new Query<WoyaodangfangzhuEntity>(params).getPage(),
                new EntityWrapper<WoyaodangfangzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WoyaodangfangzhuEntity> wrapper) {
		  Page<WoyaodangfangzhuView> page =new Query<WoyaodangfangzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WoyaodangfangzhuVO> selectListVO(Wrapper<WoyaodangfangzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WoyaodangfangzhuVO selectVO(Wrapper<WoyaodangfangzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WoyaodangfangzhuView> selectListView(Wrapper<WoyaodangfangzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WoyaodangfangzhuView selectView(Wrapper<WoyaodangfangzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
