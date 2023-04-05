package org.example.controller;

import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.BranchesDatabase;
import org.example.datbase.LangController;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.BranchReplayKeyboardUtil;
import org.example.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class BranchController {
    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public BranchController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String text, Message message) {

        Profile profile = profileRepository.getProfile(message.getChatId());
        if (text.startsWith("\uD83C\uDFD8") || text.startsWith("⬅️") && profile.getStep().equals(ProfileStep.BRANCHES2)) {
            profile.setStep(ProfileStep.BRANCHES1);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.getBranch(profile.getLang()));
            sendMessage.setReplyMarkup(BranchReplayKeyboardUtil.branches1());
            myTelegramBot.sendMsg(sendMessage);
        }

        else if (text.startsWith("\uD83C\uDFE0")){
            SendMessage sendMessage= new SendMessage();
            sendMessage.setText("[Bizning filliallar](https://www.google.com/maps/search/Max+Way/@41.3268461,69.292676,13z/data=!3m1!4b1)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setChatId(message.getChatId());
            myTelegramBot.sendMsg(sendMessage );
        }else if (text.startsWith("⬅️") && profile.getStep().equals(ProfileStep.BRANCHES1)) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        } else if (text.startsWith("➡")) {
            profile.setStep(ProfileStep.BRANCHES2);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.getBranch(profile.getLang()));
            sendMessage.setReplyMarkup(BranchReplayKeyboardUtil.branches2());
            myTelegramBot.sendMsg(sendMessage);
        } else if (text.equals("MAX WAY RISOVIY")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.274899);
            sendLocation.setLongitude(69.309423);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY PARUS")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.293496);
            sendLocation.setLongitude(69.212972);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY MAGIC CITY")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.304277);
            sendLocation.setLongitude(69.244847);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY SAMARQAND DARVOZA")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.31683);
            sendLocation.setLongitude(69.231262);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY PARKENT")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.314775);
            sendLocation.setLongitude(69.325162);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY UNIVERSAM")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.363468);
            sendLocation.setLongitude(69.288586);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY ROYSON")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.322643);
            sendLocation.setLongitude(69.241973);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY NEXT")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.297983);
            sendLocation.setLongitude(69.249571);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY MUQUMIY")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.287939);
            sendLocation.setLongitude(69.229206);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY GRAND MIR")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.295095);
            sendLocation.setLongitude(69.26797);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY SERGELI")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));
            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.226369);
            sendLocation.setLongitude(69.219899);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        } else if (text.equals("MAX WAY MINOR")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(BranchesDatabase.result(profile.getLang(), text));

            myTelegramBot.sendMsg(sendMessage);
            SendLocation sendLocation = new SendLocation();
            sendLocation.setChatId(message.getChatId());
            sendLocation.setLatitude(41.326548);
            sendLocation.setLongitude(69.292786);
            myTelegramBot.sendMsg(sendLocation);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(message.getChatId());
            sendMessage1.setText(BranchesDatabase.getBranch(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage1);
        }



/*
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Salom");
        myTelegramBot.sendMsg(sendMessage);
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(message.getChatId());
        sendLocation.setLongitude(69.212972);
        sendLocation.setLatitude(41.293496);
        myTelegramBot.sendMsg(sendLocation);*/
    }
}
