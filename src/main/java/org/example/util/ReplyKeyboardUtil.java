package org.example.util;

import org.example.datbase.LangController;
import org.example.datbase.SettingDatabase;
import org.example.dto.Profile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

public class ReplyKeyboardUtil {


    public static KeyboardButton button(String text) {
        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        return button;
    }

    public static ReplyKeyboardMarkup phoneKeyboard(Profile profile) {
        KeyboardButton button = new KeyboardButton();
        button.setText(LangController.getPhoneSend(profile.getLang()) + " ☎");
        button.setRequestContact(true);

        KeyboardRow row = new KeyboardRow();
        row.add(button);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup langSetting(String lang) {


        String[] result = SettingDatabase.getSettingMenu(lang);

        KeyboardButton button = button(result[0]);
        KeyboardButton button1 = button(result[1]);
        KeyboardButton button2 = button(result[2]);


        KeyboardRow row = new KeyboardRow();
        row.add(button);
        row.add(button1);
        row.add(button2);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup upDeteBrithday(String lang){
        String[] result=SettingDatabase.getBrithday(lang);


        KeyboardButton button = button(result[0]);
        KeyboardButton button1 = button(result[1]);

        KeyboardRow row= new KeyboardRow();
        row.add(button);
        row.add(button1);

        List<KeyboardRow> rowList=new LinkedList<>();
        rowList.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup= new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);


        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;


    }

    ///   About keyboard

    public static ReplyKeyboardMarkup getAboutMenu(String lang){
        String[] result=SettingDatabase.getBrithday(lang);


        KeyboardButton button = button(result[0]);


        KeyboardRow row= new KeyboardRow();
        row.add(button);

        List<KeyboardRow> rowList=new LinkedList<>();
        rowList.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup= new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);


        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;


    }

    public static ReplyKeyboardMarkup langS(String lang) {


        String result = SettingDatabase.getlang(lang);

        KeyboardButton button = button("O`zbekcha \uD83C\uDDFA\uD83C\uDDFF");
        KeyboardButton button1 = button("Русский \uD83C\uDDF7\uD83C\uDDFA");
        KeyboardButton button2 = button("English \uD83C\uDDFA\uD83C\uDDF8");
        KeyboardButton button3 = button(result);


        KeyboardRow row = new KeyboardRow();
        row.add(button);
        row.add(button1);
        row.add(button2);
        row.add(button3);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup menuKeyboard(String lang) {

        String[] arr = LangController.getMenu(lang);
        KeyboardButton shop = button(arr[0]);
        KeyboardButton aksiya = button(arr[1]);
        KeyboardButton filiallar = button(arr[2]);
        KeyboardButton izoh = button(arr[3]);
        KeyboardButton yaqin = button(arr[4]);
        KeyboardButton sozlamalar = button(arr[5]);
        KeyboardButton order = button(arr[6]);
        KeyboardButton info = button(arr[7]);


        KeyboardRow row1 = new KeyboardRow();
        row1.add(shop);


        KeyboardRow row2 = new KeyboardRow();
        row2.add(aksiya);
        row2.add(filiallar);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(izoh);
        row3.add(yaqin);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(sozlamalar);
        row4.add(order);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(info);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

}
