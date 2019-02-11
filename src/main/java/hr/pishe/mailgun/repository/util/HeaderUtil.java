package hr.pishe.mailgun.repository.util;

import com.mashape.unirest.http.utils.Base64Coder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HeaderUtil {

    public HeaderUtil() {
    }

    public static MultiValueMap<String, String> createHeader(String username, String password, String contentType) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap();
        map.add("Authorization", "Basic " + Base64Coder.encodeString(username + ":" + password));
        if (contentType != null) {
            map.add("Content-Type", contentType);
        }

        return map;
    }
}
