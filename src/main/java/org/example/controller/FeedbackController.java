package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.FeedbackRepository;
import org.example.Repository.ProfileRepository;
import org.example.datbase.FeedbackBasa;
import org.example.datbase.LangController;
import org.example.dto.Feedback;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class FeedbackController {
    private MyTelegramBot myTelegramBot;
    private FeedbackRepository feedbackRepository;
    private ProfileRepository profileRepository;
    private int num=0;

    public FeedbackController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        feedbackRepository = new FeedbackRepository();
        profileRepository = new ProfileRepository();
    }


    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        if (text.startsWith("✍️")) {
            profile.setStep(ProfileStep.ENTER_FEEDBACK);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(FeedbackBasa.getFeedBackMenu(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.getAboutMenu(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);
        }
        else if (profile.getStep().equals(ProfileStep.ENTER_FEEDBACK) && text.startsWith("\uD83D\uDDC2 |")){
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.Menu(profile.getLang()));
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);
        }
        else if (profile.getStep().equals(ProfileStep.ENTER_FEEDBACK)){
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);
            Feedback feedback= new Feedback();
            feedback.setFeedback(text);
            feedback.setId(num++);
            feedbackRepository.saveFeedback(feedback);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.Menu(profile.getLang())+"[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);
        }


    }
}
