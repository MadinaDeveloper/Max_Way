package org.example;

import org.example.controller.CallBackController;
import org.example.controller.MainController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyTelegramBot extends TelegramLongPollingBot {

    private MainController mainController;
    private CallBackController callBackController;

    public MyTelegramBot() {
        mainController = new MainController(this);
        callBackController = new CallBackController(this);

    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {

                Message message = update.getMessage();
                log(message.getFrom().getFirstName(),message.getFrom().getLastName(),message.getFrom().getId(),message.getText());
                mainController.handle(message.getText(), message);
            } else if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String data = callbackQuery.getData();
                callBackController.handle(data,callbackQuery.getMessage());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }  public void sendMsg(SendMessage method){
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public  void sendMsg(EditMessageText method){
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public  void sendMsg(SendPhoto method){
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public  void sendMsg(SendLocation method){
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void log(String first_name, String last_name, Long user_id, String txt) {
        try {
            System.out.println("\n --------------------------------------------------------");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println(dateFormat.format(LocalDateTime.now()));
            System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "max_way_face_bot";
    }

    @Override
    public String getBotToken() {
        return "5879968190:AAHHmPebBn_0chtxPjPo4onVup4e9Qb1qUQ";
    }
}
