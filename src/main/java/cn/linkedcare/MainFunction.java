package cn.linkedcare;

import cn.linkedcare.entity.Offfice;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Benji on 2018/4/25.
 */
public class MainFunction {
    private static final String testString = "{\"empCode\":\"1552630627671751\",\"name\":\"刘伟\",\"mobilePhone\":\"18706777955\",\"email\":\"wei.liu@linkedcare.cn\",\"deptCode\":\"49144148\",\"position\":\"销售BD\",\"departments\":[\"西安\"],\"offices\":[{\"tenantCode\":\"db56c5dd-4066-4ac4-8e4d-18bda97579b6\",\"officeCode\":\"34\"},{\"tenantCode\":\"f0999ded-4f05-407a-9f12-173d276ceff0\",\"officeCode\":\"1\"},{\"tenantCode\":\"ac5a5784-f749-41da-ae18-842a1754d6b6\",\"officeCode\":\"30\"},{\"tenantCode\":\"c5ad80f1-adf0-44b3-8804-db99ba1a7991\",\"officeCode\":\"90\"},{\"tenantCode\":\"3f9e745c-0359-44e7-93ff-d22f444266f5\",\"officeCode\":\"40\"},{\"tenantCode\":\"bb81dc0d-ad0d-4c24-9846-6e5d17c5b869\",\"officeCode\":\"23\"},{\"tenantCode\":\"ed882f1a-0f11-43d6-8303-5aee467a138e\",\"officeCode\":\"31\"},{\"tenantCode\":\"41615f98-05f9-4a61-a840-b8b0f7e8e57b\",\"officeCode\":\"46\"},{\"tenantCode\":\"29fc7130-2f4a-47ac-9419-2125486691b3\",\"officeCode\":\"30\"},{\"tenantCode\":\"440ee880-725e-4d7d-b32e-17380a4ce06c\",\"officeCode\":\"37\"},{\"tenantCode\":\"a0536c15-4a45-474a-addc-480192bd9951\",\"officeCode\":\"12\"},{\"tenantCode\":\"016ae01b-9a75-4f21-938c-155c50c6360a\",\"officeCode\":\"25\"},{\"tenantCode\":\"1bf38008-94cf-4ae1-a6a1-5e572f2660b1\",\"officeCode\":\"57\"},{\"tenantCode\":\"bd3ef028-14b0-405a-a5af-8ba649cfcae2\",\"officeCode\":\"13\"},{\"tenantCode\":\"2b75d711-84e4-4fb5-b0c8-a4ca424b5732\",\"officeCode\":\"74\"},{\"tenantCode\":\"95e4d520-c3d4-49ff-bdd0-4ed77cdca508\",\"officeCode\":\"10\"},{\"tenantCode\":\"85ff1d47-42f6-467f-af33-1f5104d9aa95\",\"officeCode\":\"19\"},{\"tenantCode\":\"68046038-2449-47c1-a7eb-1c380070be58\",\"officeCode\":\"38\"},{\"tenantCode\":\"35ba770c-e43b-48a1-a5a1-ddcc0ef8f499\",\"officeCode\":\"49\"},{\"tenantCode\":\"1625a4bd-b854-41ef-ac27-650f17d589c3\",\"officeCode\":\"56\"},{\"tenantCode\":\"80905b7b-108e-4e61-a0aa-78d8f5de8888\",\"officeCode\":\"59\"},{\"tenantCode\":\"e072fa86-7df2-49a4-a8a0-88441fa66a12\",\"officeCode\":\"30\"},{\"tenantCode\":\"e092d336-3e2d-4b95-8771-cf38eb469e9f\",\"officeCode\":\"55\"},{\"tenantCode\":\"e177d9ad-8b3c-4051-8d29-d4c5b80ab249\",\"officeCode\":\"43\"},{\"tenantCode\":\"65c80cf3-b039-42b7-ac71-bdab2d7af91c\",\"officeCode\":\"50\"},{\"tenantCode\":\"01a2a44e-ab34-4232-a561-88115ea764e7\",\"officeCode\":\"9\"},{\"tenantCode\":\"4336a333-1f7f-4e1a-b0f1-903d9e2d90bd\",\"officeCode\":\"18\"},{\"tenantCode\":\"686fcba3-ea90-45f4-8a0f-6d1f22f5d16a\",\"officeCode\":\"15\"},{\"tenantCode\":\"17e88f24-969d-4968-bbfd-cefe05c1d7f5\",\"officeCode\":\"37\"},{\"tenantCode\":\"8a3cba98-fe51-421e-a3f2-fe2388cc7524\",\"officeCode\":\"55\"},{\"tenantCode\":\"a53ab941-39f9-4091-9dd8-e81096f87f6b\",\"officeCode\":\"33\"},{\"tenantCode\":\"3a33b216-3af1-4c1c-a69b-8423ca1e4632\",\"officeCode\":\"51\"},{\"tenantCode\":\"8eeb5234-9564-45fa-9cb9-f31e763d15ba\",\"officeCode\":\"35\"},{\"tenantCode\":\"3811c44c-71b3-4d19-ad40-b36de44ea09c\",\"officeCode\":\"57\"},{\"tenantCode\":\"fa9b792e-38e7-4755-a1b5-b8cac0ea01d9\",\"officeCode\":\"63\"},{\"tenantCode\":\"14dc2986-5e74-46df-b8b8-828db6b8a18b\",\"officeCode\":\"63\"},{\"tenantCode\":\"5b656450-cce0-470c-b0e9-503843e65bd8\",\"officeCode\":\"2\"},{\"tenantCode\":\"c45a1336-3207-477f-811f-94f002875794\",\"officeCode\":\"3\"},{\"tenantCode\":\"6a9a6f0d-1173-42ba-9814-32a0c4d67d90\",\"officeCode\":\"13\"},{\"tenantCode\":\"9deed316-566b-4e2a-87e8-2d93953fdc26\",\"officeCode\":\"32\"},{\"tenantCode\":\"66e34866-a5e9-4900-9664-3c842dfc572e\",\"officeCode\":\"47\"},{\"tenantCode\":\"75ecbc0d-121a-42ea-9069-4c2e59a32793\",\"officeCode\":\"48\"},{\"tenantCode\":\"30fc190e-5c67-48de-9fb4-cd52bb393021\",\"officeCode\":\"2\"},{\"tenantCode\":\"0ae4d711-43f1-41f4-9d0c-984ae1167cac\",\"officeCode\":\"7\"},{\"tenantCode\":\"7407c595-c7a2-47e4-a706-e62539e549dd\",\"officeCode\":\"51\"},{\"tenantCode\":\"56ebd597-a6ef-4432-8092-476cdd10a778\",\"officeCode\":\"25\"},{\"tenantCode\":\"4c99f2fb-15a9-4fa4-b86b-934edaec93a7\",\"officeCode\":\"41\"},{\"tenantCode\":\"8913cc4d-5837-4fed-8df0-95fba42c5719\",\"officeCode\":\"21\"},{\"tenantCode\":\"01dd3bf5-193c-41fa-99b1-1b3456406fb3\",\"officeCode\":\"50\"},{\"tenantCode\":\"f734d99d-7871-4b25-86c4-c3a484e4a223\",\"officeCode\":\"32\"},{\"tenantCode\":\"162be08d-9bd2-4aa6-b28b-86ddba76d5a2\",\"officeCode\":\"23\"},{\"tenantCode\":\"b851daec-7766-449a-9d5f-ea4315c2ce43\",\"officeCode\":\"3\"},{\"tenantCode\":\"5fcac4cf-ffa9-4011-a47c-a9dc3626daa0\",\"officeCode\":\"38\"},{\"tenantCode\":\"b28906e7-98d9-4c69-829f-a09da871b846\",\"officeCode\":\"4\"},{\"tenantCode\":\"c78e6708-4b45-4110-aefb-409ca5c7831f\",\"officeCode\":\"19\"},{\"tenantCode\":\"fbc33783-6f83-46a1-8a35-78129b07afa6\",\"officeCode\":\"3\"},{\"tenantCode\":\"b6154d1a-0bc5-4c1c-8053-782ed0e7bab4\",\"officeCode\":\"7\"},{\"tenantCode\":\"ec4db924-175b-4604-a4c6-db26045fd68d\",\"officeCode\":\"17\"},{\"tenantCode\":\"c78e6708-4b45-4110-aefb-409ca5c7831f\",\"officeCode\":\"25\"},{\"tenantCode\":\"30fc190e-5c67-48de-9fb4-cd52bb393021\",\"officeCode\":\"53\"},{\"tenantCode\":\"3fa1a77c-c506-483f-9b2c-847e77c70577\",\"officeCode\":\"16\"},{\"tenantCode\":\"02637398-3bf5-4a79-bc59-e2dc433e7c44\",\"officeCode\":\"8\"},{\"tenantCode\":\"c5ad80f1-adf0-44b3-8804-db99ba1a7991\",\"officeCode\":\"88\"},{\"tenantCode\":\"402e82b9-746b-4040-8894-848a12b099f2\",\"officeCode\":\"26\"},{\"tenantCode\":\"17cab1c6-eb15-4c0f-9f15-dbfecb1c67fb\",\"officeCode\":\"82\"},{\"tenantCode\":\"dbf24254-37bb-4cf8-a07f-e63e554689e0\",\"officeCode\":\"10\"}]}";

    public static void main(String[] args) throws IOException {
        //testFastJson();
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        testDate(instance);

    }

    public static void fun1() {
        String str = "6♧5♢10";
        String[] split = str.split("[♧♢]");
        List<String> list = Arrays.stream(split)
                .filter(item -> StringUtils.isNotBlank(item))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }


    public static void testFastJson() {
        long sum = 0;
        for (int i = 0; i < 100; i++) {
            long begin = System.currentTimeMillis();
            JSONObject jsonObject = JSON.parseObject(testString);
            List<Offfice> offfices = jsonObject.getJSONArray("offices").toJavaList(Offfice.class);
            StringBuilder sb = new StringBuilder("(");
            offfices.forEach(offfice -> {
                sb.append("\'").append(offfice.getTenantCode())
                        .append(offfice.getOfficeCode()).append("\'")
                        .append(",");
            });
            String substring = sb.substring(0, sb.lastIndexOf(",")) + ")";
            sum = sum + (System.currentTimeMillis() - begin);
            System.out.println(substring + "---->" + i);
        }
        BigDecimal count = new BigDecimal(sum).divide(new BigDecimal(100)).setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.print("Fastjson平均用时" + count + "ms");
    }


    public static void testDate(Calendar calendar) {
        Date beginDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date endDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("beginDate:" + dateFormat.format(beginDate));
        System.out.println("endDate:" + dateFormat.format(endDate));
    }

}
