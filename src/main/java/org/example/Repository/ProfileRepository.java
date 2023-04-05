package org.example.Repository;

import org.example.dto.Profile;
import org.example.enums.ProfileStep;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProfileRepository {

    public Profile getProfile(Long id) {
        Optional<Profile> optional = getAll().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return optional.orElse(null);
    }

    public List<Profile> getAll() {
        try {
            Stream<String> lines = Files.lines(Path.of("profile.txt"));
            return lines.map(s -> {
                String arr[] = s.split("#");
                Profile profile = new Profile(Long.valueOf(arr[0]));
                profile.setUsername(arr[1]);
                profile.setName(arr[2]);
                profile.setPhone(arr[3]);
                profile.setStep(ProfileStep.valueOf(arr[4]));
                profile.setLang(arr[5]);
                profile.setBrithday(arr[6]);
                return profile;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }


    public void update(Profile profile) {
        List<Profile> profileList = getAll();
        profileList.removeIf(p -> p.getId().equals(profile.getId()));
        profileList.add(profile);
        rewrite(profileList);
    }

    public void saveProfile(Profile profile) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("profile.txt", true));
            printWriter.println(profile.writableString());
            printWriter.flush();
            printWriter.close();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void rewrite(List<Profile> list) {

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("profile.txt"));
            list.forEach(profile -> {
                printWriter.println(profile.writableString());
            });
            printWriter.flush();
            printWriter.close();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

}
