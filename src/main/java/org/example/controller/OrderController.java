package org.example.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.example.Location.LocationMap;
import org.example.MyTelegramBot;
import org.example.Repository.ProfileRepository;
import org.example.datbase.LangController;
import org.example.datbase.OrderDatabase;
import org.example.dto.LocationBr;
import org.example.dto.Profile;
import org.example.enums.ProfileStep;
import org.example.util.FoodMenu;
import org.example.util.OrderReplayKeyboardUtil;
import org.example.util.ReplyKeyboardUtil;
import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;
import java.net.URL;

public class OrderController {
    private MyTelegramBot myTelegramBot;
    private ProfileRepository profileRepository;

    public OrderController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
        profileRepository = new ProfileRepository();
    }

    public void handle(String text, Message message) {
        Profile profile = profileRepository.getProfile(message.getChatId());
        if (text.startsWith("\uD83D\uDECD")) {
            profile.setStep(ProfileStep.ORDER1);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(OrderDatabase.order(profile.getLang()));
            sendMessage.setReplyMarkup(OrderReplayKeyboardUtil.order1(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        }
        ///🚖
        else if (text.startsWith("\uD83D\uDE96")) {
            profile.setStep(ProfileStep.DOSTAVKA);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(OrderDatabase.orderDastovka(profile.getLang()));
            sendMessage.setReplyMarkup(OrderReplayKeyboardUtil.dostavka(profile));
            myTelegramBot.sendMsg(sendMessage);
        } else if (profile.getStep().equals(ProfileStep.DOSTAVKA) && text.startsWith("⬅️ ")) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            profile.setStep(ProfileStep.REG_DONE);
            profileRepository.update(profile);
            sendMessage.setText(LangController.Menu(profile.getLang()) + "[MaxWay menu](https://telegra.ph/Menyu-12-19-39)");
            sendMessage.setParseMode("Markdown");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.menuKeyboard(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        } else if (profile.getStep().equals(ProfileStep.DOSTAVKA) && text.startsWith("✅")) {
            profile.setStep(ProfileStep.MENU_ORDER);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.foodMenu(profile.getLang()));
            sendMessage.setReplyMarkup(FoodMenu.foodMenu(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        }
        else if (text.startsWith("\uD83C\uDFC3")) {
            profile.setStep(ProfileStep.MENU_BRANCHES);
            profileRepository.update(profile);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(LangController.foodMenu(profile.getLang()));
            sendMessage.setReplyMarkup(FoodMenu.foodMenu(profile.getLang()));
            myTelegramBot.sendMsg(sendMessage);

        }
        else if (profile.getStep().equals(ProfileStep.DOSTAVKA) && text.equals(OrderDatabase.dostavka(profile.getLang())[0])) {

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText("Location");
            sendMessage.setReplyMarkup(OrderReplayKeyboardUtil.dostavka(profile));
            myTelegramBot.sendMsg(sendMessage);
        }


    }

    public void handle(Message message) throws IOException {

        Profile profile = profileRepository.getProfile(message.getChatId());
        Location location = message.getLocation();
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();

        URL url = new URL("https://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lon + "&addressdetails=1");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();
        JSONObject object = new JSONObject(json);
        System.out.println(object);
        JSONObject address = object.getJSONObject("address");
        String country = address.getString("country") + "," + address.getString("city") + ","
                + address.getString("county");
        System.out.println(country);
        String[] arr = OrderDatabase.location1(profile.getLang());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(arr[0] + country + arr[1]);
        sendMessage.setReplyMarkup(OrderReplayKeyboardUtil.location(profile.getLang()));
        myTelegramBot.sendMsg(sendMessage);

        String name=LocationMap.getNear(lat,lon);
        LocationBr loc=LocationMap.locationMap(name);
        System.out.println(loc);
        SendLocation sendLocation= new SendLocation();
        sendLocation.setChatId(message.getChatId());
        sendLocation.setLatitude(loc.getLat());
        sendLocation.setLongitude(loc.getLon());
        myTelegramBot.sendMsg(sendLocation);





    }


}
