package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.datbase.SettingDatabase;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.MessageUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public class MainController {
    private MyTelegramBot myTelegramBot;
    private ProfileController profileController;
    private ProfileRepository profileRepository;
    private SettingController settingController;
    private AboutController aboutController;
    private FeedbackController feedbackController;
    private BranchController branchController;
    private OrderController orderController;
    private SaleController saleController;

    public MainController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileController = new ProfileController(myTelegramBot);
        settingController = new SettingController(myTelegramBot);
        profileRepository = new ProfileRepository();
        aboutController = new AboutController(myTelegramBot);
        feedbackController = new FeedbackController(myTelegramBot);
        branchController = new BranchController(myTelegramBot);
        orderController = new OrderController(myTelegramBot);
        saleController = new SaleController(myTelegramBot);
    }

    public void handle(String text, Message message) throws IOException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        Profile profile = profileRepository.getProfile(message.getChatId());
        System.out.println(profile);
        if (message.hasText()) {
            if (text.equals("/start") || profile.getStep().equals(ProfileStep.ENTER_NAME)) {
                profileController.handle(text, message);
            } else if (text.startsWith("⚙️") || text.equals(SettingDatabase.getSettingMenu(profile.getLang())[0])
                    || profile.getStep().equals(ProfileStep.Change_Language) || text.equals(SettingDatabase.getSettingMenu(profile.getLang())[1])
                    || profile.getStep().equals(ProfileStep.ENTER_BRITHDAY) || text.startsWith("\uD83D\uDDC2 |")
                    || profile.getStep().equals(ProfileStep.SETTING)) {
                settingController.handle(text, message);
            } else if (text.startsWith("ℹ")) {
                aboutController.handle(text, message);
            } else if (text.startsWith("✍️") || profile.getStep().equals(ProfileStep.ENTER_FEEDBACK)) {
                feedbackController.handle(text, message);
            } else if (text.startsWith("\uD83C\uDFD8 ") || profile.getStep().equals(ProfileStep.BRANCHES1)
                    || profile.getStep().equals(ProfileStep.BRANCHES2) || text.startsWith("\uD83C\uDFE0")) {
                branchController.handle(text, message);
            } else if (text.startsWith("\uD83D\uDECD") || text.startsWith("\uD83D\uDE96") || text.startsWith("\uD83C\uDFC3") ||
                    profile.getStep().equals(ProfileStep.DOSTAVKA)) {
                orderController.handle(text, message);
            } else if (text.startsWith("\uD83C\uDF89")) {
                saleController.handle(text, message);
            } else {
                System.out.println();
                myTelegramBot.sendMsg(MessageUtil.notFound(message.getChatId()));
            }
        } else if (message.hasContact()) {
            Contact contact = message.getContact();
            profileController.handle(contact);
        } else if (message.hasLocation() && profile.getStep().equals(ProfileStep.DOSTAVKA)) {
            orderController.handle(message);
        }

    }
}
