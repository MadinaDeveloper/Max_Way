package org.example.datbase;

import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;

import java.util.HashMap;
import java.util.Map;

public class BranchesDatabase {
    public static String getBranch(String lang) {
        Map<String, String> branches = new HashMap<>();
        branches.put("uz", "Bizning filiallarimiz :");
        branches.put("ru", "Наши филиалы :");
        branches.put("en", "Our branches :");
        return branches.get(lang);
    }

   /* public static String getRisovy(String lang) {
        Map<String, String> branches = new HashMap<>();
        branches.put("uz", "\uD83D\uDCCD Filial:  MAX WAY RISOVIY \n" +
                "                           \n" +
                "\uD83D\uDDFA Manzil:  Узбекистан, Ташкент, Алтынкульская улица, 10 \n" +
                "                           \n" +
                "\uD83C\uDFE2 Orientir:  банкетный зал Тантана \n" +
                "                           \n" +
                "☎️ Telefon raqami:  +998712005400\n" +
                "                           \n" +
                "\uD83D\uDD59 Ish vaqti : 09:00 - 03:00");
        branches.put("ru", "\uD83D\uDCCD Филиал:  MAX WAY RISOVIY \n" +
                "                           \n" +
                "\uD83D\uDDFA Адрес:  Узбекистан, Ташкент, Алтынкульская улица, 10 \n" +
                "                           \n" +
                "\uD83C\uDFE2 Ориентир:  банкетный зал Тантана \n" +
                "                           \n" +
                "☎️ Номер для связи:  +998712005400\n" +
                "                           \n" +
                "\uD83D\uDD59 Рабочие часы: 09:00 - 03:00");
        branches.put("en", "\uD83D\uDCCD Branch:  MAX WAY RISOVIY \n" +
                "                           \n" +
                "\uD83D\uDDFA Address:  Узбекистан, Ташкент, Алтынкульская улица, 10 \n" +
                "                           \n" +
                "\uD83C\uDFE2 Landmark:  банкетный зал Тантана \n" +
                "                           \n" +
                "☎️ Phone number:  +998712005400\n" +
                "                           \n" +
                "\uD83D\uDD59 Working hours : 09:00 - 03:00");
        return branches.get(lang);
    }

    public static String getParus(String lang) {
        Map<String, String> branches = new HashMap<>();
        branches.put("uz", "\uD83D\uDCCD Filial:  MAX WAY PARUS \n" +
                "                           \n" +
                "\uD83D\uDDFA Manzil:  Узбекистан, Ташкент, улица Катартал, 60/5 \n" +
                "                           \n" +
                "\uD83C\uDFE2 Orientir:  ТЦ Парус \n" +
                "                           \n" +
                "☎️ Telefon raqami:  +998712005400\n" +
                "                           \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 03:00" +
                "                           \n" +
                "\uD83D\uDD59 Ish vaqti : 09:00 - 03:00");
        branches.put("ru", "\uD83D\uDCCD Филиал:  MAX WAY RISOVIY \n" +
                "                           \n" +
                "\uD83D\uDDFA Адрес:  Узбекистан, Ташкент, Алтынкульская улица, 10 \n" +
                "                           \n" +
                "\uD83C\uDFE2 Ориентир:  банкетный зал Тантана \n" +
                "                           \n" +
                "☎️ Номер для связи:  +998712005400\n" +
                "                           \n" +
                "\uD83D\uDD59 Рабочие часы: 09:00 - 03:00");
        branches.put("en", "\uD83D\uDCCD Branch:  MAX WAY PARUS \n" +
                "                           \n" +
                "\uD83D\uDDFA Address:  Узбекистан, Ташкент, улица Катартал, 60/5 \n" +
                "                           \n" +
                "\uD83C\uDFE2 Landmark:  ТЦ Парус \n" +
                "                           \n" +
                "☎️ Phone number:  +998712005400\n" +
                "                           \n" +
                "\uD83D\uDD59 Working hours : 10:00 - 03:00");
        return branches.get(lang);
    }*/

    public static String[] getAll(String lang) {
        Map<String, String[]> branches = new HashMap<>();
        String[] uz = {"\uD83D\uDCCD Filial:  ", "\uD83D\uDDFA Manzil:  ", "\uD83C\uDFE2 Orientir:  ", "☎️ Telefon raqami:  +998712005400\n\n", "\uD83D\uDD59 Ish vaqti : "};
        String[] ru = {"\uD83D\uDCCD Филиал:  ", "\uD83D\uDDFA Адрес:  ", "\uD83C\uDFE2 Ориентир:  ", "☎️ Номер для связи:  +998712005400\n\n", "\uD83D\uDD59 Рабочие часы: "};
        String[] en = {"\uD83D\uDCCD Branch:  ", "\uD83D\uDDFA Address:  ", "\uD83C\uDFE2 Landmark:  ", "☎️ Phone number:  +998712005400\n\n", "\uD83D\uDD59 Working hours : "};
        branches.put("uz", uz);
        branches.put("ru", ru);
        branches.put("en", en);
        return branches.get(lang);
    }

    public static String[] getBranches(String lang) {
        Map<String, String[]> branches = new HashMap<>();
        String[] risovy = {"MAX WAY RISOVIY \n\n", "Узбекистан, Ташкент, Алтынкульская улица, 10 \n\n",
                "банкетный зал Тантана \n\n", "09:00 - 03:00"};
        String[] parus = {"MAX WAY PARUS \n\n", "Узбекистан, Ташкент, улица Катартал, 60/5 \n\n",
                "ТЦ Парус\n\n", "10:00 - 03:00"};
        String[] magic = {"MAX WAY MAGIC CITY \n\n", "Узбекистан, Ташкент, улица Бабура, 174/6 \n\n",
                " Magic City \n\n", "10:00 - 22:00"};
        String[] samarqand = {"MAX WAY SAMARQAND DARVOZA \n\n", "Узбекистан, Ташкент, улица Коратош, 5А \n\n",
                "Chorsu \n\n", "10:00-22:00"};
        String[] parkent = {"MAX WAY PARKENT \n\n", " Узбекистан, Ташкент, Яшнободский район, массив Мавлоно Риёзи, 30В \n\n",
                "Паркентский рынок \n\n", "09:00 - 03:00"};
        String[] universam = {"MAX WAY UNIVERSAM \n\n", "  Узбекистан, Ташкент, улица Заркайнар, 2  \n\n",
                "Юнусабад Универсам \n\n", "09:00 - 18:00"};
        String[] royson = {"MAX WAY ROYSON \n\n", "Узбекистан, Ташкент, улица Заркайнар, 2 \n\n",
                "Цирк  \n\n", "09:00 - 01:00"};
        String[] next = {"MAX WAY NEXT \n\n", "Узбекистан, Ташкент, улица Бабура, 6\n\n",
                "Некст  \n\n", " 07:59 - 08:00"};
        String[] muqumiy = {"MAX WAY MUQUMIY \n\n", " Узбекистан, Ташкент, улица Чиланзар \n\n",
                "Чиланзар 1-й квартал \n\n", "09:00 - 03:00"};
        String[] garantmir = {"MAX WAY GRAND MIR   \n\n", " Узбекистан, Ташкент, улица Шота Руставели, 9А \n\n",
                "Гостиница Гранд Мир  \n\n", "09:00 - 03:00"};
        String[] sayram = {"MAX WAY SAYRAM   \n\n", " Узбекистан, Ташкент, улица Юнусота \n\n",
                "NO  \n\n", "09:00 - 03:00"};
        String[] maksim = {"MAX WAY MAKSIM GORKIY   \n\n", " Узбекистан, Ташкент, улица Буюк Ипак Йули, 4 \n\n",
                "Буюк Ипак Йули Ⓜ️ \n\n", "09:00 - 23:00"};
        String[] sergili = {"MAX WAY SERGELI \n\n", " :  Узбекистан, Ташкент, Сергелийский район, массив Сергели-VIIIА, 11 \n\n",
                "Сергели Дехкон Бозори  \n\n", "09:00 - 03:00"};
        String[] fontan = {"MAX WAY FONTAN   \n\n", " Узбекистан, Ташкент, Юнусабадский район, массив Юнусабад, 3-й квартал, 21 \n\n",
                "Yunusabot  \n\n", "09:00 - 03:00"};
        String[] minor = {"MAX WAY MINOR   \n\n", " MaxWay \n\n",
                "бывший кинотеатр Казахстан   \n\n", "09:00 - 03:00"};

        branches.put("MAX WAY RISOVIY", risovy);
        branches.put("MAX WAY PARUS", parus);
        branches.put("MAX WAY MAGIC CITY", magic);
        branches.put("MAX WAY SAMARQAND DARVOZA", samarqand);
        branches.put("MAX WAY PARKENT", parkent);
        branches.put("MAX WAY UNIVERSAM", universam);
        branches.put("MAX WAY ROYSON", royson);
        branches.put("MAX WAY NEXT", next);
        branches.put("MAX WAY MUQUMIY", muqumiy);
        branches.put("MAX WAY GRAND MIR", garantmir);
        branches.put("MAX WAY SAYRAM", sayram);
        branches.put("MAX WAY MAKSIM GORKIY", maksim);
        branches.put("MAX WAY SERGELI", sergili);
        branches.put("MAX WAY FONTAN", fontan);
        branches.put("MAX WAY MINOR", minor);
        return branches.get(lang);
    }
    public static String result(String lang,String text){
        String[] langResult=getAll(lang);
        String[] branch=getBranches(text);
        String result=langResult[0]+branch[0]+langResult[1]+branch[1]+langResult[2]+branch[2]+langResult[3]+langResult[4]+branch[3];
        return result;
    }

}
