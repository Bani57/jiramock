package com.endava.jiramock.model;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SessionModel {
    private String sessionId = generateRandomPassword();
    private Date date=new Date();

    public SessionModel() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date=date;
    }

    public String getSessionId() {

        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    private String generateRandomPassword() {
        List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1), new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1));
        PasswordGenerator generator = new PasswordGenerator();
        return generator.generatePassword(10, rules);
    }

}