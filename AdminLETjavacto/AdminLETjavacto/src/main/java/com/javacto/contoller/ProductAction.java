package com.javacto.contoller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javacto.po.Product;
import com.javacto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;

/**
 * describe
 * 作者：曾昭武
 */
@Controller
@RequestMapping("/product")
public class ProductAction {

    @Autowired
    private ProductService productService;

    //查询
    @RequestMapping("/queryAll")
    public  String queryAll(Model model){
        //调用业务层方法
        List<Product> list = productService.findAll();

        model.addAttribute("productList",list);

        return "product-list";
    }

    /**
     *  分页查询
     *  pageNum 当前页
     *  pageSize  每页显示多少条数据
     */
    @RequestMapping("/queryAllPageList")
    //@RolesAllowed("ROLE_USER")
    // @RolesAllowed({"ROLE_USER"})
    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
    public  String queryAllPageList(Model model, Integer pageNum, Integer pageSize){
        //如果pageNum 为null的时候
        if(pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=2;
        }
        PageHelper.startPage(pageNum,pageSize);
        //调用业务层方法
        List<Product> list = productService.findAll();

        PageInfo<Product> info=new PageInfo<Product>(list);

        model.addAttribute("productList",info.getList());
        model.addAttribute("info",info);
        model.addAttribute("pageSize",pageSize);

        return "product-list-page";
    }



    @RequestMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") String id){
        productService.delete(id);
        return "redirect:/rest/product/queryAllPageList";
    }

    /**
     * 根据id查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("findById")
    public String findById(String id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("msg","update");
        //修改与添加同一个页面

        return "product-add";
    }
    @RequestMapping("/update")
    public  String update(Product product){
        productService.update(product);
        return "redirect:/rest/product/queryAllPageList";
    }

    /**
     * 添加
     */
    @RequestMapping("/save")
    public  String save(Product product){
        //使用UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        product.setId(uuid);

        productService.save(product);

        return "redirect:/rest/product/queryAllPageList";
    }

    /**
     * 批量删除
     */
    @RequestMapping("/deleteProducts")
    public  String deleteProducts(String sbq){
        //需要调用业务层，
        //下面这些代码应该在业务层去写
        String[] strs = sbq.split(",");
        for(String id:strs){
            System.out.println(id  );
            //这里需要调用dao层删除方法
            productService.delete(id);
        }
        return "redirect:/rest/product/queryAllPageList";
    }

}
