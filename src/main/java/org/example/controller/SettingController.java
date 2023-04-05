package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.datbase.SettingDatabase;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.InlineKeyBoardUtil;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class SettingController {
    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public SettingController(MyTelegramBot myTelegramBot) {

        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        if (text.startsWith("⚙")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            profile.setStep(ProfileStep.SETTING);
            profileRepository.update(profile);
            sendMessage.setText(LangController.getLangSetting(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.langSetting(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        } else if (text.startsWith("⬅️") && profile.getStep().equals(ProfileStep.SETTING)) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        }

        // til o'zgartirish

        else if (profile.getStep().equals(ProfileStep.SETTING) && text.equals(SettingDatabase.getSettingMenu(profile.getLang())[0])) {
            profile.setStep(ProfileStep.Change_Language);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.getLangUpdete(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.langS(profile.getLang()));

            myTelegramBot.sendMsg(sendMessage);

        } else if (profile.getStep().equals(ProfileStep.SETTING) && text.equals(SettingDatabase.getSettingMenu(profile.getLang())[1])) {
            profile.setStep(ProfileStep.ENTER_BRITHDAY);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(SettingDatabase.getDay(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.upDeteBrithday(profile.getLang()));

            myTelegramBot.sendMsg(sendMessage);

        } else if (text.startsWith("\uD83D\uDDC2 |")) {
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));

            myTelegramBot.sendMsg(sendMessage);
        } else if (profile.getStep().equals(ProfileStep.ENTER_BRITHDAY) && text.startsWith("⬅️")
                || profile.getStep().equals(ProfileStep.Change_Language) && text.startsWith("⬅️")) {
            profile.setStep(ProfileStep.SETTING);
            profileRepository.update(profile);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.getLangSetting(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.langSetting(profile.getLang()));

            myTelegramBot.sendMsg(sendMessage);

        } else if (profile.getStep().equals(ProfileStep.ENTER_BRITHDAY)) {
            if (SettingDatabase.testBrithday(text)) {
                profile.setBrithday(text);
                profileRepository.update(profile);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(message.getChatId());
                sendMessage.setText(SettingDatabase.setDay(profile.getLang()));
                sendMessage.setReplyMarkup(ReplyKeyboardUtil.upDeteBrithday(profile.getLang()));

                myTelegramBot.sendMsg(sendMessage);
            } else {


                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(message.getChatId());
                sendMessage.setText(SettingDatabase.getDay(profile.getLang()));
                sendMessage.setReplyMarkup(ReplyKeyboardUtil.upDeteBrithday(profile.getLang()));

                myTelegramBot.sendMsg(sendMessage);

            }
        } else if (profile.getStep().equals(ProfileStep.Change_Language)) {
            profile.setStep(ProfileStep.REG_DONE);
            profile.setLang(SettingDatabase.getUpdeteLang(text));
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));

            myTelegramBot.sendMsg(sendMessage);
        } else if (text.startsWith("\uD83D\uDECD")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.getPhone(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.phoneKeyboard(profile));

            myTelegramBot.sendMsg(sendMessage);
        }
    }
}
