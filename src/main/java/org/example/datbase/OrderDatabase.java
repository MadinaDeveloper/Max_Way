package org.example.datbase;

import java.util.HashMap;
import java.util.Map;

public class OrderDatabase {


    public static String[] location(String lang){
        Map<String, String[]> location = new HashMap<>();
        String[] uz={"Lokatsiyani yuborish","✅ Tasdiqlash","Mening manzillarim","⬅️ Orqaga"};
        String[] ru={"Отправит местоположение","✅ Подтвердить","Добавить в мои адреса","⬅️  Назад"};
        String[] en={"Resend location","✅ Confirm","Add to my addresses","⬅️ Back"};
        location.put("uz",uz);
        location.put("ru",ru);
        location.put("en",en);
    return location.get(lang);
    }
    public static String[] location1(String lang){
        Map<String, String[]> location = new HashMap<>();
        String[] uz={"Manzilingiz:\n","\nManzilni tasdiqlaysizmi?"};
        String[] ru={"Ваш адрес:\n"," \nПодтвердите адрес?"};
        String[] en={"Your address:\n","\nDo you confirm address?"};
        location.put("uz",uz);
        location.put("ru",ru);
        location.put("en",en);
        return location.get(lang);
    }

 public static String[] getOrder(String lang){
     Map<String, String[]> orderDastavka = new HashMap<>();
     String[] uz={"\uD83D\uDE96 Yetkazib berish","\uD83C\uDFC3 Olib ketish","⬅️ Orqaga"};
     String[] ru={"\uD83D\uDE96  Доставка","\uD83C\uDFC3 Самовывоз","⬅️  Назад"};
     String[] en={"\uD83D\uDE96 Delivery","\uD83C\uDFC3 Pickup","⬅️ Back"};
     orderDastavka.put("uz",uz);
     orderDastavka.put("ru",ru);
     orderDastavka.put("en",en);
     return orderDastavka.get(lang);
 }
    public static String[] dostavka(String lang){
        Map<String, String[]> Dastavka = new HashMap<>();
        String[] uz={"Lokatsiya yuborish","Mening manzillarim","⬅️ Orqaga"};
        String[] ru={" Отправит местоположение","Мои адреса","⬅️  Назад"};
        String[] en={"Send location","My addresses","⬅️ Back"};
        Dastavka.put("uz",uz);
        Dastavka.put("ru",ru);
        Dastavka.put("en",en);
        return Dastavka.get(lang);
    }
 public static String order(String lang){
     Map<String, String> order = new HashMap<>();
     order.put("uz","Yetkazib berish turini tanlang");
     order.put("ru","Выберите тип доставки");
     order.put("en","Choose a delivery type");
     return order.get(lang);
 }
    public static String orderDastovka(String lang){
        Map<String, String> order = new HashMap<>();
        order.put("uz","Buyurtmani davom ettirish uchun iltimos lokatsiyangizni yuboring");
        order.put("ru","Чтобы продолжить заказ, отправьте свое местоположение");
        order.put("en","To continue your order, please send your location");
        return order.get(lang);
    }

}
