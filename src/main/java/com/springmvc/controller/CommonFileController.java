/**
 * 
 */
package com.springmvc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.fileUtil.FileUtils.ExodusTemplate;


/**
 * @author admin
 *2016年2月14日
 */
@Controller("commonFileController")
@RequestMapping("/commonFile")
public class CommonFileController {

	/**
	 * 下载模版文件
	 */
	@RequestMapping(value = "/download")
	public void download(@RequestParam(required=true) String fileName,HttpServletRequest request, HttpServletResponse response) {
        try {
        	ExodusTemplate template = ExodusTemplate.get(fileName);
        	String servletPath = request.getSession().getServletContext().getRealPath("/");
        	String path = null;
        	switch (template) {
			case DAILYGOODSHOP:
				path = servletPath+ExodusTemplate.DAILYGOODSHOP.getPath();
				break;
			default:
				break;
			}
        	String decode = URLDecoder.decode(path, "utf-8");
        	File file = new File(decode);
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
			response.addHeader("Cache-Control", "s-maxage=31536000");
			response.addHeader("Cache-Control", "no-cache");
			
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            out.write(buffer);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
