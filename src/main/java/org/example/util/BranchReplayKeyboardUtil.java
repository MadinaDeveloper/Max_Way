package org.example.util;

import org.example.datbase.SettingDatabase;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

public class BranchReplayKeyboardUtil {

    public static KeyboardButton button(String text) {
        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        return button;
    }

    public static ReplyKeyboardMarkup branches1() {


        KeyboardButton button0 = button("⬅️ Orqaga");
        KeyboardButton button1 = button("➡️ Oldinga");
        KeyboardButton button2 = button("MAX WAY RISOVIY");
        KeyboardButton button3 = button("MAX WAY PARUS");
        KeyboardButton button4 = button("MAX WAY MAGIC CITY");
        KeyboardButton button5 = button("MAX WAY SAMARQAND DARVOZA");
        KeyboardButton button6 = button("MAX WAY PARKENT");
        KeyboardButton button7 = button("MAX WAY UNIVERSAM");
        KeyboardButton button8 = button("MAX WAY ROYSON");
        KeyboardButton button9 = button("MAX WAY NEXT");
        KeyboardButton button10 = button("MAX WAY MUQUMIY");
        KeyboardButton button11 = button("MAX WAY GRAND MIR");


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


        List<KeyboardRow> rowList = new LinkedList<>();
        rowList.add(row);
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


    public static ReplyKeyboardMarkup branches2() {


        KeyboardButton button0 = button("⬅️ Orqaga");
        KeyboardButton button1 = button("MAX WAY SAYRAM");
        KeyboardButton button2 = button("MAX WAY MAKSIM GORKIY");
        KeyboardButton button3 = button("MAX WAY SERGELI");
        KeyboardButton button4 = button("MAX WAY FONTAN");
        KeyboardButton button5 = button("MAX WAY MINOR");


        KeyboardRow row = new KeyboardRow();
        row.add(button0);
        row.add(button1);
//        button0.setRequestLocation(true);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);
        row1.add(button3);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);

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

}
