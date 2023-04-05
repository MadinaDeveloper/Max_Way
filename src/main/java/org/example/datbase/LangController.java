package org.example.datbase;

import java.util.HashMap;
import java.util.Map;

public class LangController {

    public static String getLang(String lang) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("uz", "Ismingizni kiriting.");
        langMap.put("en", "Enter your name.");
        langMap.put("ru", "Введите ваше имя.");
        return langMap.get(lang);
    }

    public static String getPhone(String lang) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("uz", "Raqamingizni kiriting");
        langMap.put("en", "Enter your number");
        langMap.put("ru", "Введите свой номер");
        return langMap.get(lang);
    }

    public static String getPhoneSend(String lang) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("uz", "Raqamni jo'natish");
        langMap.put("en", "Send number");
        langMap.put("ru", "Отправить номер");
        return langMap.get(lang);
    }

    public static String getLangSetting(String lang) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("uz", "Sozlamani tanlang");
        langMap.put("en", "Change Language");
        langMap.put("ru", "Выберите настройку");
        return langMap.get(lang);
    }
    public static String getLangUpdete(String lang) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("uz", "O'zgartirmoqchi bo'lgan tilingizni tanlang");
        langMap.put("en", "Choose a language which you want to change");
        langMap.put("ru", "Выберите язык, который хотите изменить");
        return langMap.get(lang);
    }

    public static String[] getMenu(String lang) {
        Map<String, String[]> langMap = new HashMap<>();
        String[] uz = {"\uD83D\uDECD Buyurtma berish", "\uD83C\uDF89 Aksiya", "\uD83C\uDFD8 Barcha filiallar", "✍️Izoh qoldirish", "\uD83C\uDFE0 Eng yaqin filial", "⚙️ Sozlamalar", "\uD83D\uDCCB Mening buyurtmalarim","ℹ️ Biz haqimizda"};
        String[] en = {"\uD83D\uDECD Order", "\uD83C\uDF89 Sale", "\uD83C\uDFD8 Branches", "✍️ Leave feedback", "\uD83C\uDFE0 Nearest branch", "⚙️ Settings", "\uD83D\uDCCB My orders","ℹ️ About us"};
        String[] ru = {"\uD83D\uDECD Заказать", "\uD83C\uDF89 Акция", "\uD83C\uDFD8 Филиалы", "✍️ Оставить отзыв", "\uD83C\uDFE0 Ближайший филиал", " ⚙️ Настройки", "\uD83D\uDCCB Мои заказы","ℹ️ О нас"};
        langMap.put("uz", uz);
        langMap.put("en", en);
        langMap.put("ru", ru);
        return langMap.get(lang);
    }

    public static String[] getSetting(String lang) {
        Map<String, String[]> langMap = new HashMap<>();
        String[] uz = {"Tilni o'zgartirish","Tug'ilgan kunni qo'shish","⬅️ Orqaga"};
        String[] en = {"Change Language","Add Birthday","⬅️  Back"};
        String[] ru = {"Изменить язык","Добавить день рождения","⬅️  Назад"};
        langMap.put("uz", uz);
        langMap.put("en", en);
        langMap.put("ru", ru);
        return langMap.get(lang);
    }

    public static String Menu(String lang) {
        Map<String, String> langMap = new HashMap<>();
        langMap.put("uz", "Buyurtma berishni boshlash uchun \uD83D\uDECD Buyurtma berish tugmasini bosing\n" +
                " \n" +
                "Shuningdek, aksiyalarni ko'rishingiz va bizning filiallar bilan tanishishingiz mumkin \n" +
                "\n");
        langMap.put("en", "Press \uD83D\uDECD Order to make an order\n" +
                " \n" +
                "As well as familiarize yourself with sales and our branches \n" +
                "\n" );
        langMap.put("ru", "Для заказа нажмите \uD83D\uDECD Заказать\n" +
                " \n" +
                "А также вы можете посмотреть акции и ознакомиться с местонахождением наших филиалов \n" +
                "\n");
        return langMap.get(lang);
    }
    public static String sale(String lang) {
        Map<String, String> langMap = new HashMap<>();

        langMap.put("uz", "Hozirgi vaqtda hech qanday aksiyalar yo'q");
        langMap.put("en", "There are currently no sales");
        langMap.put("ru", "В настоящее время нет акций");
        return langMap.get(lang);
    }
    public static String foodMenu(String lang) {
        Map<String, String> langMap = new HashMap<>();

        langMap.put("uz", "Kategoriyani tanlang");
        langMap.put("en", "Choose a category");
        langMap.put("ru", "Выберите категорию");
        return langMap.get(lang);
    }


}
