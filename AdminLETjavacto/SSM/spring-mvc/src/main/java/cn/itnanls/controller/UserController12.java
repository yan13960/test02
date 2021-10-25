package cn.itnanls.controller;

import cn.itnanls.entity.User;
import cn.itnanls.util.R;
import cn.itnanls.util.ResultCode;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * SpringMVC整个的执行流程
 * 1.发起请求到前端控制器（DispatcherServlet）
 * 2.前端控制器请求HandlerMapping查找Handler（一般是要执行的拦截器和处理器）（根据注解，xml进行查找）
 * 3.处理映射器HandlerMapping向前端控制器DispatcherServlet返回handler
 * 4.前端控制器调用处理适配器HandlerAdapter找到合适的处理器Handler执行handler
 * 5.处理器执行handler
 * 6.处理器Handler执行完之后给处理器适配器返回ModelAndView
 * 7.处理适配器向前端控制器返回ModelAndView
 * 8.前端控制器请求视图解析器去解析视图（jsp）
 * 9.视图解析器向前端控制器返回view
 * 10.前端控制器进行视图渲染
 * 11.前端控制器向用户响应结果
 */
@Controller
@RequestMapping("/user12/")
public class UserController12 {

    @Value("${baseUrl}")
    private String baseUrl;

    @PostMapping("upload")
    @ResponseBody
    public R upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();
        System.out.println("上传文件名 : " + uploadFileName);
        //上传路径保存设置
       /* String path = "D:/upload";
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址：" + realPath);
        //就问香不香，就和你写读流一样
        file.transferTo(new File(path + "/" + uploadFileName));*/


        //如果路径不存在，创建一个
        File realPath = new File(baseUrl);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址：" + realPath);
        //就问香不香，就和你写读流一样
        file.transferTo(new File(baseUrl + uploadFileName));
        return R.of(ResultCode.SUCCESS);
    }

    @SneakyThrows
    @GetMapping("download1")
    @ResponseBody
    public R download1(HttpServletResponse response) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
             //以文件形式下载
            String fileName = "表关系.txt";
            //1、设置response 响应头，处理中文名字乱码问题
            response.reset(); //设置页面不缓存,清空buffer
            response.setCharacterEncoding("UTF-8"); //字符编码
            response.setContentType("multipart/form-data"); //二进制传输数据
          //设置响应头，就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
          //Content-Disposition属性有两种类型：inline 和 attachment
          //inline ：将文件内容直接显示在页面
            // attachment：弹出对话框让用户下载具体例子：
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            File file = new File("D:/upload/" + fileName);
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
                outputStream.flush();
            }
            return R.of(ResultCode.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return R.of(ResultCode.UNKNOWN_ERROR);
        }finally {
            if( fileInputStream != null ){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( outputStream != null ){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @GetMapping("/download2")
    public ResponseEntity<byte[]> download2(){
        try {
            String fileName = "表关系.txt";
            byte[] bytes = FileUtils.readFileToByteArray(new File("D:/upload/"+fileName));
            HttpHeaders headers=new HttpHeaders();
//Content-Disposition就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            headers.set("Content-Disposition","attachment;filename="+
                    URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity=new ResponseEntity<>(bytes,headers,
                    HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}


