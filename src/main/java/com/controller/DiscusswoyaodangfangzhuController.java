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

import com.entity.DiscusswoyaodangfangzhuEntity;
import com.entity.view.DiscusswoyaodangfangzhuView;

import com.service.DiscusswoyaodangfangzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 我要当房主评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@RestController
@RequestMapping("/discusswoyaodangfangzhu")
public class DiscusswoyaodangfangzhuController {
    @Autowired
    private DiscusswoyaodangfangzhuService discusswoyaodangfangzhuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu, HttpServletRequest request){
        EntityWrapper<DiscusswoyaodangfangzhuEntity> ew = new EntityWrapper<DiscusswoyaodangfangzhuEntity>();
		PageUtils page = discusswoyaodangfangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswoyaodangfangzhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu, HttpServletRequest request){
        EntityWrapper<DiscusswoyaodangfangzhuEntity> ew = new EntityWrapper<DiscusswoyaodangfangzhuEntity>();
		PageUtils page = discusswoyaodangfangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswoyaodangfangzhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu){
       	EntityWrapper<DiscusswoyaodangfangzhuEntity> ew = new EntityWrapper<DiscusswoyaodangfangzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusswoyaodangfangzhu, "discusswoyaodangfangzhu")); 
        return R.ok().put("data", discusswoyaodangfangzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu){
        EntityWrapper< DiscusswoyaodangfangzhuEntity> ew = new EntityWrapper< DiscusswoyaodangfangzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusswoyaodangfangzhu, "discusswoyaodangfangzhu")); 
		DiscusswoyaodangfangzhuView discusswoyaodangfangzhuView =  discusswoyaodangfangzhuService.selectView(ew);
		return R.ok("查询我要当房主评论表成功").put("data", discusswoyaodangfangzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu = discusswoyaodangfangzhuService.selectById(id);
        return R.ok().put("data", discusswoyaodangfangzhu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu = discusswoyaodangfangzhuService.selectById(id);
        return R.ok().put("data", discusswoyaodangfangzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu, HttpServletRequest request){
    	discusswoyaodangfangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusswoyaodangfangzhu);
        discusswoyaodangfangzhuService.insert(discusswoyaodangfangzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu, HttpServletRequest request){
    	discusswoyaodangfangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusswoyaodangfangzhu);
        discusswoyaodangfangzhuService.insert(discusswoyaodangfangzhu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusswoyaodangfangzhuEntity discusswoyaodangfangzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusswoyaodangfangzhu);
        discusswoyaodangfangzhuService.updateById(discusswoyaodangfangzhu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusswoyaodangfangzhuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscusswoyaodangfangzhuEntity> wrapper = new EntityWrapper<DiscusswoyaodangfangzhuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusswoyaodangfangzhuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
