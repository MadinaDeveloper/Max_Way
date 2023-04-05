package org.example.datbase;

import java.util.HashMap;
import java.util.Map;

public class FeedbackBasa {
    public static String getFeedBackMenu(String lang) {
        Map<String, String> feedback = new HashMap<>();
        feedback.put("uz","Izoh qoldiring. Sizning fikringiz biz uchun muhim");
        feedback.put("ru","Оставьте свой отзыв. Нам важно ваше мнение.");
        feedback.put("en","Leave your feedback. Your opinion is important for us");
        return feedback.get(lang);
    }
}
