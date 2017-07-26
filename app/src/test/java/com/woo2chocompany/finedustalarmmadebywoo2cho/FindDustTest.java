package com.woo2chocompany.finedustalarmmadebywoo2cho;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by user on 2017-07-26.
 */

public class FindDustTest {

    private FindDustInfo findDustInfo;

    @Test
    public void test1() throws JSONException {
        findDustInfo = new FindDustInfo();
        String returnStr = findDustInfo.findDustInfo("서울");

        JSONObject json = new JSONObject(returnStr);

        viewJsonData(json);

        assertThat(json, is(notNullValue()));
    }

    public void viewJsonData(JSONObject json) throws JSONException {
        JSONArray lists = json.getJSONArray("list");
        //	        JSONObject json1 = (JSONObject)lists.get(0);

        System.out.println("리스트 갯수 : " + lists.length());


        for(int i=0;i<lists.length();i++) {
            JSONObject json1 = (JSONObject) lists.get(i);
            System.out.println("도시 : "+json1.get("stationName"));
            System.out.println("측정일 : "+json1.get("dataTime"));
            System.out.println("통합대기환경수치 : "+json1.get("khaiValue"));
            System.out.println("통합대기환경지수 : "+returnGrade(json1.get("khaiGrade")));
            System.out.println("미세먼지(PM10)지수 : "+returnGrade(json1.get("pm10Grade")));
            System.out.println("미세먼지(PM10) : "+json1.get("pm10Value"));
            System.out.println("미세먼지(PM2.5)지수 : "+returnGrade(json1.get("pm25Grade")));
            System.out.println("미세먼지(PM2.5) : "+json1.get("pm25Value"));
        }
    }
    public String returnGrade(Object gradeObj) {
        String gradeStr = gradeObj.toString();
        if(gradeStr.matches("\\d")) {
            int gradeInt = Integer.parseInt(gradeStr);

            switch(gradeInt) {
                case 1: gradeStr = "좋음"; break;
                case 2: gradeStr = "보통"; break;
                case 3: gradeStr = "나쁨"; break;
                case 4: gradeStr = "매우나쁨"; break;
            }
        }

        return gradeStr;
    }
}
