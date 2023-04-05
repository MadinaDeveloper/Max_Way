package org.example.Repository;

import org.example.dto.Feedback;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FeedbackRepository {

    public void saveFeedback(Feedback feedback) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("feedback.txt", true));
            printWriter.println(feedback.writableString());
            printWriter.flush();
            printWriter.close();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
