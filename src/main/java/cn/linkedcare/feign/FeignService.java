package cn.linkedcare.feign;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Created by Benji on 2018/4/10.
 */
public interface FeignService {

    @RequestLine("POST /token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    String getToken(@Param("grant_type") String grantType,
                    @Param("client_id") String clientId,
                    @Param("client_secret") String clientSecret);

    @RequestLine("POST /api/v1/users")
    String getOfficeInfoByEmail(Object param);


    @RequestLine("POST /api/v1/users/sync")
    String getUsers(Object param);
}
