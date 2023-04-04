package translate;

import basic.ByteUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

public class TranslateUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // String q = "我爱我媳妇";
        // String q = "Good Morning/Afternoon/Evening!(根据实际情况修改)";
        String q = "Good Morning/Afternoon/Evening!";
        char char0 = q.charAt(0);
        // boolean matchChinese = PatternUtil.matchChinese(char0);

        String translateResult = translateResult(q, "en", "zh");
        System.out.println(translateResult);

    }

    private static String translateResult(String q, String from, String to) throws UnsupportedEncodingException {

        String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

        from = StringUtil.isEmpty(from) ? "zh" : from;

        to = StringUtil.isEmpty(to) ? "en" : to;

        String appid = "20180103000111543";

        String p = "hKhTn4umupyJxY61Beny";

        Random random = new Random();
        int salt_int = random.nextInt();
        String salt = String.valueOf(salt_int);

        String sign_source = appid + q + salt_int + p;
        String sign = DigestUtils.md5Hex(sign_source);

        // q = URLEncoder.encode(q, "UTF-8");
        String trans_url = url + "?" + "q=" + q + "&from=" + from + "&to=" + to + "&appid=" + appid + "&salt=" + salt + "&sign=" + sign;

        System.out.println(trans_url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resEntity = restTemplate.getForEntity(trans_url, String.class);

        String result = resEntity.getBody();
        System.out.println(result);

        String dstUni = JSON.parseObject(result).getJSONArray("trans_result").getJSONObject(0).getString("dst");
        System.out.println(dstUni);
        String dst = ByteUtil.unicodeToChar(dstUni);
        System.out.println(dst);

        return result;
    }

}
