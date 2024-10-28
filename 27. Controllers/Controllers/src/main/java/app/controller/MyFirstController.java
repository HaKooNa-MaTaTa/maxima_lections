package app.controller;

import app.dto.SignUpForm;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Говорим Spring`у, что данный класс будет реагировать на запросы
@RequestMapping("/controllers") //Данной аннотацией мы говорим Spring`у на какой урл будет откликаться данный контроллер
public class MyFirstController {

    //1. Он отреагирует на запрос GET {host}:{port}/controller
//    @RequestMapping(method = RequestMethod.GET)
//    public String hello() {
//        return "Hello! You are in custom controller!";
//    }

    //2. @GetMapping - все то же самое, что в пункте 1
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("{ \"message:\" \"Hello! You are in custom controller!\" }");
    }

    //3.1 http://localhost:8080/controllers - получение приветственной надписи
    //3.2 http://localhost:8080/controllers/all-list - получение урлов всех контроллеров приложения
    //3.3 http://localhost:8080/controllers/active-list - получение урлов всех доступных контроллеров приложения
    @GetMapping("/all-list") //http://localhost:8080/controllers/all-list
    public ResponseEntity<String> hello_3() {
        //Сервис с бизнес логикой
        return ResponseEntity.ok("{ \"message:\" \"This is list of all controllers - he is empty\" }");
    }

    @PostMapping
    public ResponseEntity someMethod(@RequestBody String message) {
        System.out.println(message);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signUp(@RequestBody SignUpForm form) {
        System.out.println(form.getName());
        System.out.println(form.getEmail());

        return "signUp";
    }
}
