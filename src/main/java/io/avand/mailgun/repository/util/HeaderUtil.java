package io.avand.mailgun.repository.util;

import com.mashape.unirest.http.utils.Base64Coder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HeaderUtil {

    public static MultiValueMap<String,String> createHeader(String username,String password){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("Authorization","Basic "+ Base64Coder.encodeString(username + ":" + password));
        return map;
    }

}
