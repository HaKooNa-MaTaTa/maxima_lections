package app.controller;

import app.dto.AccountDto;
import app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SignUpController implements Controller {

    private final AccountService accountService;

    @Autowired
    public SignUpController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        //POST, post, PoSt, pOsT...
        if (request.getMethod().equalsIgnoreCase("post")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            accountService.signUp(AccountDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build());
            modelAndView.setViewName("accounts");
            modelAndView.addObject("accounts", accountService.getAll());
        } else {
            modelAndView.setViewName("signUp");
        }
        return modelAndView;
    }
}
