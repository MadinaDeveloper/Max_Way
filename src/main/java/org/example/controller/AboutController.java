package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.datbase.SettingDatabase;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class AboutController {

    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public AboutController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        if (text.startsWith("ℹ")) {


            profile.setStep(ProfileStep.ENTER_ABOUT);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(SettingDatabase.getAbout(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.getAboutMenu(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);
        } else if (text.startsWith("\uD83D\uDDC2 |")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        }
    }
}
