package org.example.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class InlineKeyBoardUtil {

    public static InlineKeyboardButton button(String text, String callBack) {
        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setCallbackData(callBack);
        return button;
    }

    public  static InlineKeyboardMarkup  getLangMenu(){
        InlineKeyboardButton button1 = InlineKeyBoardUtil.button(" \uD83C\uDDFA\uD83C\uDDFF UZ", "/lang/uz/");
        InlineKeyboardButton button2 = InlineKeyBoardUtil.button(" \uD83C\uDDFA\uD83C\uDDF8 EN", "/lang/en/");
        InlineKeyboardButton button3 = InlineKeyBoardUtil.button(" \uD83C\uDDF7\uD83C\uDDFA RU", "/lang/ru/");


        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row1);


        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
