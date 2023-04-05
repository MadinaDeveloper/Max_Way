package org.example.datbase;

import java.util.HashMap;
import java.util.Map;

public class SettingDatabase {

    public static boolean testBrithday(String lang) {
        String[] arr = lang.split("-");
        if (arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4) {
            return true;
        }
        return false;
    }


    public static String[] getBrithday(String lang) {
        Map<String, String[]> langSetting = new HashMap<>();
        String[] uz = {"\uD83D\uDDC2 | Asosiy menu", "⬅️ Orqaga"};
        String[] ru = {"\uD83D\uDDC2 | Главное меню", "⬅️  Назад"};
        String[] en = {"\uD83D\uDDC2 | Main menu", "⬅️  Back"};

        langSetting.put("uz", uz);
        langSetting.put("ru", ru);
        langSetting.put("en", en);
        return langSetting.get(lang);
    }


    public static String getDay(String lang) {
        Map<String, String> langSetting = new HashMap<>();

        langSetting.put("uz", "Tug'ilgan kunni «01-12-2000» shu formatda kiriting");
        langSetting.put("ru", "Введите свой день рождения в формате, похожем на «01-12-2000»");
        langSetting.put("en", "Enter your birthday in a format similar to «01-12-2000»");
        return langSetting.get(lang);
    }

    public static String getAbout(String lang) {
        Map<String, String> langSetting = new HashMap<>();

        langSetting.put("uz", "\uD83C\uDF5F Max Way \n" +
                "☎️ Aloqa markazi: +998712005400");
        langSetting.put("ru", "\uD83C\uDF5F Max Way \n" +
                "☎️ Единый call центр: +998712005400");
        langSetting.put("en", "\uD83C\uDF5F Max Way \n" +
                "☎️ Call center +998712005400");
        return langSetting.get(lang);
    }

    public static String setDay(String lang) {
        Map<String, String> langSetting = new HashMap<>();

        langSetting.put("uz", "Tug'ilgan kun qo'shildi  ");
        langSetting.put("en", "Birthday added successfully");
        langSetting.put("ru", "День рождения успешно добавлен.");
        return langSetting.get(lang);
    }

    public static String getlang(String lang) {
        Map<String, String> langSetting = new HashMap<>();

        langSetting.put("uz", "⬅️  Orqaga");
        langSetting.put("ru", "⬅️  Back");
        langSetting.put("en", "⬅️  Назад");
        return langSetting.get(lang);
    }

    public static String[] getSettingMenu(String lang) {
        Map<String, String[]> lan = new HashMap<>();
        String[] uz = {"Tilni o`zgartirish", "Tug`ulgan kunni qo`shish", "⬅️  Orqaga"};
        String[] en = {"Change Language", "Add Birthday", "⬅️  Back"};
        String[] ru = {"Изменить язык", "Добавить день рождения", "⬅️  Назад"};
        lan.put("uz", uz);
        lan.put("ru", ru);
        lan.put("en", en);
        return lan.get(lang);

    }

    public static String getUpdeteLang(String lang) {
        Map<String, String> langSetting = new HashMap<>();

        langSetting.put("O`zbekcha \uD83C\uDDFA\uD83C\uDDFF", "uz");
        langSetting.put("Русский \uD83C\uDDF7\uD83C\uDDFA", "ru");
        langSetting.put("English \uD83C\uDDFA\uD83C\uDDF8", "en");
        return langSetting.get(lang);
    }
}
