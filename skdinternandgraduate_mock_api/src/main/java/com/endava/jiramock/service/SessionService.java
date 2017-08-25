package com.endava.jiramock.service;

import com.endava.jiramock.model.SessionModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@Service
public class SessionService {
    @Value("${session.timeout.minutes}")
    private Integer minutes;
    private HashMap<String,Date> hashmap=new HashMap<>();

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public HashMap<String, Date> getHashmap() {
        return hashmap;
    }

    public void setHashmap(HashMap<String, Date> hashmap) {
        this.hashmap = hashmap;
    }

    public void insertSession(SessionModel sessionModel)
    {
        hashmap.put(sessionModel.getSessionId(),sessionModel.getDate());
    }
    public SessionResponseEnumeration checkSession(String sessionId){
        if(!hashmap.containsKey(sessionId))
            return SessionResponseEnumeration.UNAUTHORIZED;
        else {
            Date now = new Date();
            Long difference = now.getTime() - hashmap.get(sessionId).getTime();
            difference = TimeUnit.MILLISECONDS.toMinutes(difference);
            if (difference >= minutes) {
                hashmap.remove(sessionId);
                return SessionResponseEnumeration.EXPIRED;
            }
            else
                return SessionResponseEnumeration.SUCCESS;
        }
    }
}
