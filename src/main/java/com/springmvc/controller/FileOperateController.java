package com.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.fileUtil.FileOperateUtil;

@Controller
@RequestMapping("back/")
public class FileOperateController {
	/**
	 *到上传位置
	 *  
	 * @return
	 */
	@RequestMapping("to_upload")
	public ModelAndView toUpload() {
		return new ModelAndView("upload");
	}

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "upload")
	public ModelAndView upload(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//别名
		String[] names = ServletRequestUtils.getStringParameters(request,
				"filename");
		String[] params = new String[] { "filename" };
		System.out.println("**********names:"+names.length+"***params:"+params.length+"-"+params[0]);
		Map<String, Object[]> values = new HashMap<String, Object[]>();
		values.put("filename", names);
		List<Map<String, Object>> result = FileOperateUtil.upload(request,
				params, values);
		map.put("result", result);
		return new ModelAndView("list", map);
	}

	@RequestMapping("download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String storeName = "201205051340364510870879724.zip";
		String realName = "Java金典入门.zip";
		String contentType = "application/octet-stream";
		FileOperateUtil.download(request, response, storeName, contentType, realName);
		return null;
	}

}
