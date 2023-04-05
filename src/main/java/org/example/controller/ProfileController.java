package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.InlineKeyBoardUtil;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ProfileController {


    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public ProfileController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        if (text.equals("/start") && profile!=null) {
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);
        }
        else if (text.equals("/start")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText("Здравствуйте! Добро пожаловать в наш бот! \n" +
                    "Давайте для начала выберем язык обслуживания!\n" +
                    "        \n" +
                    "Assalomu aleykum! Botimizga xush kelibsiz! \n" +
                    "Keling, avvaliga xizmat ko’rsatish tilini tanlab olaylik. \n" +
                    "        \n" +
                    "Hello! Welcome to our Bot! \n" +
                    "Let's choose the language of service first");
            sendMessage.setReplyMarkup(InlineKeyBoardUtil.getLangMenu());
            myTelegramBot.sendMsg(sendMessage);
        } else if (profile.getStep().equals(ProfileStep.ENTER_NAME)) {
            profile.setName(text);
            profile.setUsername(message.getFrom().getUserName());
            profile.setStep(ProfileStep.ENTER_PHONE);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.getPhone(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.phoneKeyboard(profile));

            myTelegramBot.sendMsg(sendMessage);
        } else if (text.startsWith("\uD83D\uDECD")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.getPhone(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.phoneKeyboard(profile));

            myTelegramBot.sendMsg(sendMessage);
        }
    }

    public void handle(Contact contact) {
        Profile profile = profileRepository.getProfile(contact.getUserId());
        profile.setPhone(contact.getPhoneNumber());
        profile.setStep(ProfileStep.REG_DONE);
        profileRepository.update(profile);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(contact.getUserId());
        sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
        sendMessage.setParseMode("Markdown");
        sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
        myTelegramBot.sendMsg(sendMessage);
    }


}
