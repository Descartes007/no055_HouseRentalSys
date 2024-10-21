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

import com.entity.YuyuekanfangEntity;
import com.entity.view.YuyuekanfangView;

import com.service.YuyuekanfangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 预约看房
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@RestController
@RequestMapping("/yuyuekanfang")
public class YuyuekanfangController {
    @Autowired
    private YuyuekanfangService yuyuekanfangService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yuyuekanfang.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangzhu")) {
			yuyuekanfang.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuekanfangEntity> ew = new EntityWrapper<YuyuekanfangEntity>();
		PageUtils page = yuyuekanfangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuekanfang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
        EntityWrapper<YuyuekanfangEntity> ew = new EntityWrapper<YuyuekanfangEntity>();
		PageUtils page = yuyuekanfangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuekanfang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuekanfangEntity yuyuekanfang){
       	EntityWrapper<YuyuekanfangEntity> ew = new EntityWrapper<YuyuekanfangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuekanfang, "yuyuekanfang")); 
        return R.ok().put("data", yuyuekanfangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuekanfangEntity yuyuekanfang){
        EntityWrapper< YuyuekanfangEntity> ew = new EntityWrapper< YuyuekanfangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuekanfang, "yuyuekanfang")); 
		YuyuekanfangView yuyuekanfangView =  yuyuekanfangService.selectView(ew);
		return R.ok("查询预约看房成功").put("data", yuyuekanfangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuekanfangEntity yuyuekanfang = yuyuekanfangService.selectById(id);
        return R.ok().put("data", yuyuekanfang);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuekanfangEntity yuyuekanfang = yuyuekanfangService.selectById(id);
        return R.ok().put("data", yuyuekanfang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
    	yuyuekanfang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuekanfang);
        yuyuekanfangService.insert(yuyuekanfang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
    	yuyuekanfang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuekanfang);
        yuyuekanfangService.insert(yuyuekanfang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuekanfang);
        yuyuekanfangService.updateById(yuyuekanfang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuekanfangService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YuyuekanfangEntity> wrapper = new EntityWrapper<YuyuekanfangEntity>();
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
		if(tableName.equals("fangzhu")) {
			wrapper.eq("fangzhuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yuyuekanfangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
