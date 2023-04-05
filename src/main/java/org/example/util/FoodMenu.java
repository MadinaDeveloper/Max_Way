package org.example.util;

import org.example.datbase.FoodDatabase;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

public class FoodMenu {
    public static KeyboardButton button(String text) {
        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        return button;
    }

    public static ReplyKeyboardMarkup foodMenu(String lang) {

        String[] arr = FoodDatabase.getFoodMenu(lang);
        KeyboardButton button0 = button(arr[0]);
        KeyboardButton button1 = button(arr[1]);
        KeyboardButton button2 = button(arr[2]);
        KeyboardButton button3 = button(arr[3]);
        KeyboardButton button4 = button(arr[4]);
        KeyboardButton button5 = button(arr[5]);
        KeyboardButton button6 = button(arr[6]);
        KeyboardButton button7 = button(arr[7]);
        KeyboardButton button8 = button(arr[8]);
        KeyboardButton button9 = button(arr[9]);
        KeyboardButton button10 = button(arr[10]);
        KeyboardButton button11 = button(arr[11]);
        KeyboardButton button12 = button(arr[12]);
        KeyboardButton button13 = button(arr[13]);
        KeyboardButton button14 = button(arr[14]);


        KeyboardRow row = new KeyboardRow();
        row.add(button0);
        row.add(button1);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);
        row1.add(button3);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button6);
        row3.add(button7);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button8);
        row4.add(button9);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button10);
        row5.add(button11);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button12);
        row6.add(button13);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button14);



        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);

        replyKeyboardMarkup.setResizeKeyboard(true);//buttonni razmerini to'g'irlaydi
        replyKeyboardMarkup.setSelective(true);// bottinga strelka qoshadi;
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

}
