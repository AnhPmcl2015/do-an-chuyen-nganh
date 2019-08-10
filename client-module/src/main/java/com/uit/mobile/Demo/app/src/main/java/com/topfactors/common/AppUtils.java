package com.topfactors.common;

import com.topfactors.dto.ApiResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Cái này dùng để tạo các hàm có chức năng thực hiện 1 tác vụ gì đó mà không phụ thuộc vào object
 */
public final class AppUtils {

    /**
     * Gửi sendRequest đến server
     * @param requestUrl
     * @param accessToken
     * @return
     */
    public static ApiResponse sendGetRequest(String requestUrl, String accessToken){
        StringBuffer jsonString = new StringBuffer();
        URL url = null;
        HttpURLConnection con = null;
        ApiResponse apiResponse = new ApiResponse();

        try{
            url = new URL(requestUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", Constants.TOKEN_TYPE + Constants.SPACE + accessToken);
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            if(con.getResponseCode() == ResponseCode.SUCCESS){
                String line;

                while((line = br.readLine()) != null){
                    jsonString.append(line);
                }
                br.close();
                apiResponse.setCode(ResponseCode.SUCCESS);
                apiResponse.setMessage(jsonString.toString());

            }else {
                BufferedReader brError = new BufferedReader(new InputStreamReader(con.getErrorStream()));

                String line;
                while((line = brError.readLine()) != null){
                    jsonString.append(line);
                }

                String message = ErrorMessage.ERROR_REMARK + con.getResponseCode() + Constants.SPACE + jsonString.toString();
                apiResponse.setCode(con.getResponseCode());
                apiResponse.setMessage(message);
            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(con != null) con.disconnect();
        }

        return apiResponse;
    }

    /**
     * Gửi Post request xuống server
     * @param url
     * @param accessToken
     * @param params
     * @return
     */
    public static ApiResponse sendPostRequest(String requestUrl, String accessToken, String params){
        StringBuffer jsonString = new StringBuffer();
        URL url = null;
        HttpURLConnection con = null;
        ApiResponse apiResponse = new ApiResponse();

        try{
            url = new URL(requestUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", Constants.TOKEN_TYPE + Constants.SPACE + accessToken);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);

            con.setReadTimeout(Constants.READ_TIME_OUT);
            con.setConnectTimeout(Constants.CONNECT_TIME_OUT);

            con.connect();

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(params);
            wr.flush();
            wr.close();

            if(con.getResponseCode() == ResponseCode.SUCCESS){
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                while((line = br.readLine()) != null){
                    jsonString.append(line);
                }

                apiResponse.setCode(ResponseCode.SUCCESS);
                apiResponse.setMessage(jsonString.toString());
            }else{
                BufferedReader brError = new BufferedReader(new InputStreamReader(con.getErrorStream()));

                String line;
                while((line = brError.readLine()) != null){
                    jsonString.append(line);
                }

                apiResponse.setCode(con.getResponseCode());
                apiResponse.setMessage(jsonString.toString());
            }


        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(con != null) con.disconnect();
        }

        return apiResponse;
    }


}
