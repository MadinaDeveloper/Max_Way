package org.example.util;

import org.example.datbase.OrderDatabase;
import org.example.dto.Profile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;

public class OrderReplayKeyboardUtil {
    public static KeyboardButton button(String text) {
        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        return button;
    }

    public static ReplyKeyboardMarkup order1(String lang) {

        String[] result = OrderDatabase.getOrder(lang);

        KeyboardButton button0 = button(result[0]);
        KeyboardButton button1 = button(result[1]);
        KeyboardButton button2 = button(result[2]);


        KeyboardRow row = new KeyboardRow();
        row.add(button0);
        row.add(button1);
//        button0.setRequestLocation(true);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);


        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup dostavka(Profile profile) {

        String[] result = OrderDatabase.dostavka(profile.getLang());

        KeyboardButton button0 = button(result[0]);
        button0.setRequestLocation(true);
        KeyboardButton button1 = button(result[1]);
        KeyboardButton button2 = button(result[2]);


        KeyboardRow row = new KeyboardRow();
        row.add(button0);

//        button0.setRequestLocation(true);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);

        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup location(String lang) {

        String[] result = OrderDatabase.location(lang);

        KeyboardButton button0 = button(result[0]);
        KeyboardButton button1 = button(result[1]);
        KeyboardButton button2 = button(result[2]);
        KeyboardButton button3 = button(result[3]);


        KeyboardRow row = new KeyboardRow();
        row.add(button0);
        row.add(button1);
//        button0.setRequestLocation(true);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);
        row1.add(button3);


        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }
}
