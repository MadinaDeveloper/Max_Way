package org.example.datbase;

import java.util.HashMap;
import java.util.Map;

public class FoodDatabase {

    public static String[] getFoodMenu(String lang) {
        Map<String, String[]> branches = new HashMap<>();
        String[] ru = {"⬅️  Назад", "\uD83D\uDCE5 Корзина","\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64Макси бокс","\uD83E\uDD6AКлаб-сэндвич",
                "\uD83C\uDF2FЛаваш", "\uD83C\uDF2EШаурма","\uD83C\uDF71Донар кебаб","\uD83E\uDED4Шаурма Баггет (хагги)",
                "\uD83C\uDF54Бургеры","\uD83C\uDF2DХот-дог","\uD83C\uDF5FСнеки","\uD83E\uDD64Напитки","\uD83C\uDF70Десерты",
                "\uD83E\uDD6BСоусы","\uD83C\uDF5AГарниры"};
        String[] en = {"⬅️  Back","\uD83D\uDCE5 Cart","\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64Maxi Box",
                "\uD83E\uDD6AClub - Sandvich","\uD83C\uDF2FLavash","\uD83C\uDF2EShawarma","\uD83C\uDF71Donar kebab",
                 "\uD83E\uDED4Shawarma Bagget (Huggie)","\uD83C\uDF54Burgers","\uD83C\uDF2DHot-Dog","\uD83C\uDF5FSnacks",
                    "\uD83E\uDD64Drinks","\uD83C\uDF70Desserts","\uD83E\uDD6BSouses","\uD83C\uDF5AGarnish"};
        String[] uz = {"⬅️ Orqaga","\uD83D\uDCE5 Savat","\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64Maxi Boks",
                "\uD83E\uDD6AClab - Sendvich","\uD83C\uDF2FLavash","\uD83C\uDF2EShaurma","\uD83C\uDF71Donar kebab",
                "\uD83E\uDED4Shaurma Bagget (Haggi)","\uD83C\uDF54Burger","\uD83C\uDF2DHot-Dog",
                "\uD83C\uDF5FGazaklar","\uD83E\uDD64Ichimliklar","\uD83C\uDF70Desertlar","\uD83E\uDD6BSouslar","\uD83C\uDF5ATamaddilar"};


        branches.put("uz", uz);
        branches.put("ru", ru);
        branches.put("en", en);
              return branches.get(lang);
    }
}
