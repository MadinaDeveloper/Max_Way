package org.example.controller;

import org.apache.http.cookie.SM;
import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class SaleController {
    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public SaleController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        profile.setStep(ProfileStep.REG_DONE);
        profileRepository.update(profile);
        SendMessage sendMessage1= new SendMessage();
        sendMessage1.setChatId(message.getChatId());
        sendMessage1.setText(LangController.sale(profile.getLang()));
        myTelegramBot.sendMsg(sendMessage1);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
        sendMessage.setParseMode("Markdown");
        sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
        myTelegramBot.sendMsg(sendMessage);
    }
}
