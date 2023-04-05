package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;


public class CallBackController {
    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public void getAllLang(String lang) {
        Map<String, String> langMap = new HashMap<>();

    }

    public CallBackController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String data, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        String[] arr = data.split("/");
        if (data.startsWith("/lang")) {
            if (profile == null) {
                createNewUser(message, arr[2]);
            } else {
                // menu
            }
        }


    }

    public void createNewUser(Message message, String s) {
        Profile profile = new Profile(message.getChatId());
        profile.setLang(s);
        profile.setStep(ProfileStep.ENTER_NAME);
        profileRepository.saveProfile(profile);


        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(LangController.getLang(s));
        myTelegramBot.sendMsg(sendMessage);
    }
}
