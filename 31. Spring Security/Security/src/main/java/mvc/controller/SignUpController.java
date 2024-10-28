package mvc.controller;

import mvc.dto.AccountDto;
import mvc.model.Account;
import mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SignUpController implements Controller {

    @Autowired
    private final AccountService accountService;

    public SignUpController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        //POST, Post, post
        if (request.getMethod().equalsIgnoreCase("post")) {
            AccountDto dto = AccountDto.builder()
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .role(Account.Role.USER)
                .state(Account.State.NOT_CONFIRMED)
                .build();
            accountService.saveAccount(dto);
            modelAndView.addObject("accounts", accountService.getAllAccounts());
            modelAndView.setViewName("accounts");
        } else {
            modelAndView.setViewName("signUp");
        }

        return modelAndView;
    }
}