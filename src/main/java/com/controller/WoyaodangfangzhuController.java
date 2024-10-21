package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WoyaodangfangzhuEntity;
import com.entity.view.WoyaodangfangzhuView;

import com.service.WoyaodangfangzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 我要当房主
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@RestController
@RequestMapping("/woyaodangfangzhu")
public class WoyaodangfangzhuController {
    @Autowired
    private WoyaodangfangzhuService woyaodangfangzhuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WoyaodangfangzhuEntity woyaodangfangzhu, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			woyaodangfangzhu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WoyaodangfangzhuEntity> ew = new EntityWrapper<WoyaodangfangzhuEntity>();
		PageUtils page = woyaodangfangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, woyaodangfangzhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WoyaodangfangzhuEntity woyaodangfangzhu, HttpServletRequest request){
        EntityWrapper<WoyaodangfangzhuEntity> ew = new EntityWrapper<WoyaodangfangzhuEntity>();
		PageUtils page = woyaodangfangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, woyaodangfangzhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WoyaodangfangzhuEntity woyaodangfangzhu){
       	EntityWrapper<WoyaodangfangzhuEntity> ew = new EntityWrapper<WoyaodangfangzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( woyaodangfangzhu, "woyaodangfangzhu")); 
        return R.ok().put("data", woyaodangfangzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WoyaodangfangzhuEntity woyaodangfangzhu){
        EntityWrapper< WoyaodangfangzhuEntity> ew = new EntityWrapper< WoyaodangfangzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( woyaodangfangzhu, "woyaodangfangzhu")); 
		WoyaodangfangzhuView woyaodangfangzhuView =  woyaodangfangzhuService.selectView(ew);
		return R.ok("查询我要当房主成功").put("data", woyaodangfangzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WoyaodangfangzhuEntity woyaodangfangzhu = woyaodangfangzhuService.selectById(id);
        return R.ok().put("data", woyaodangfangzhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WoyaodangfangzhuEntity woyaodangfangzhu = woyaodangfangzhuService.selectById(id);
        return R.ok().put("data", woyaodangfangzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WoyaodangfangzhuEntity woyaodangfangzhu, HttpServletRequest request){
    	woyaodangfangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(woyaodangfangzhu);
        woyaodangfangzhuService.insert(woyaodangfangzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WoyaodangfangzhuEntity woyaodangfangzhu, HttpServletRequest request){
    	woyaodangfangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(woyaodangfangzhu);
        woyaodangfangzhuService.insert(woyaodangfangzhu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WoyaodangfangzhuEntity woyaodangfangzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(woyaodangfangzhu);
        woyaodangfangzhuService.updateById(woyaodangfangzhu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        woyaodangfangzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<WoyaodangfangzhuEntity> wrapper = new EntityWrapper<WoyaodangfangzhuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = woyaodangfangzhuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
