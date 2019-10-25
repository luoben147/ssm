package com.luoben.controller;

import com.luoben.domain.Account;
import com.luoben.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 账户 web
 */
@Controller
@RequestMapping("/account")
public class AccountContorller {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户..");
        //调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("表现层：查询所有账户..");
        //调用service方法
         accountService.saveAccount(account);
         //保存完 重定向到findAll
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

}
