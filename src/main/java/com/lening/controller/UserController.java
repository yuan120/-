package com.lening.controller;

import com.lening.comm.ResultInfo;
import com.lening.entity.*;
import com.lening.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创作时间：2020/11/4 11:02
 * 作者：李增强
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 省市县三级联动
     */
    @ResponseBody
    @RequestMapping("/getCityListById")
    public List<CityBean> getCityListById(Long id){
        return userService.getCityListById(id);
    }

    /**
     * 查询班级列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGradeList")
    public List<GradeBean> getGradeList(){
        return userService.getGradeList();
    }

    @RequestMapping("/getStuAllList")
    @ResponseBody
    public List<StudentBean> getStuAllList(){
        return userService.getStuAllList();
    }

    @RequestMapping("saveStuInfo")
    @ResponseBody
    public ResultInfo saveStuInfo(@RequestBody StudentBean studentBean){
        try {
            userService.saveStuInfo(studentBean);
            return new ResultInfo(true,"更新成功");
        }catch (Exception e){
            return new ResultInfo(false,"更新失败");
        }
    }

    @RequestMapping("/deleteStudentBatch")
    @ResponseBody
    public ResultInfo deleteStudentBatch(@RequestBody Long[] sids){
        try {
            userService.deleteStudentBatch(sids);
            return new ResultInfo(true,"删除成功");
        }catch (Exception e){
            return new ResultInfo(false,"删除失败");
        }
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<UserBean> getUserList(){
        return userService.getUserList();
    }

}
