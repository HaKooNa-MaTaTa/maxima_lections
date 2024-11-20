package com.maxima.logbotstarter.service;

import com.maxima.logbotstarter.config.TelegramProperties;
import com.maxima.logbotstarter.model.StatusProject;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService extends TelegramLongPollingBot {

    private final TelegramProperties properties;

    @Autowired
    public MainService(
        @Qualifier("log-bot-com.maxima.logbotstarter.config.TelegramProperties") TelegramProperties properties) {
        super(properties.getToken());
        this.properties = properties;
    }

    //Что делать боту, когда ему пишет пользователь?
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && !update.getMessage().getText().isEmpty()) {
            String message;

            String firstName = update.getMessage().getChat().getFirstName();
            String lastName = update.getMessage().getChat().getLastName();
            Long id = update.getMessage().getChatId();

            if (update.getMessage().getText().equals("Поприветствуй меня!")) {
                //TODO: добавите регистрацию пользователя, если его не существует
                message = "Hi! " + firstName + " " + lastName + "( id = " + id + " )";
            } else if (update.getMessage().getText().equals("Попрощайся со мной!")) {
                message = "Good Bye, my Dear " + firstName + "!";
            } else {
                message = " Я не понимать, что ты от меня хотеть. Возможно, я буду уметь это позже";
            }

            System.out.println(message);
            SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), message);

            ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
            List<KeyboardRow> rows = new ArrayList<>();

            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add("Поприветствуй меня!");
            keyboardRow.add("Попрощайся со мной!");

            rows.add(keyboardRow);

            markup.setKeyboard(rows);

            sendMessage.setReplyMarkup(markup);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String getBotUsername() {
        return properties.getName();
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @PostConstruct
    private void sendStatusPostStart() {
        sendMessage(StatusProject.LAUNCHED);
    }

    @PreDestroy
    private void sendStatusPreDestroy() {
        sendMessage(StatusProject.STOPPED);
    }

    private void sendMessage(StatusProject status) {
        String message = String.format("Проект - %s \nСтатус - %s", properties.getProjectName(), status);
        SendMessage sendMessage = new SendMessage("182425314", message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
