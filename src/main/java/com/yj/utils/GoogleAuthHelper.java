package com.yj.utils;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.yj.pojo.GoogleUser;

@Component
public class GoogleAuthHelper {
	@Value("${google.clientId}")
	private String CLIENT_ID;
	
	@Value("${google.clientSecret}")
	private String CLIENT_SECRET ;
	
	@Value("${google.callback}")
	private String CALLBACK_URI;
	
	@Value("${google.userInfo}")
	private String USER_INFO_URL;

	@Autowired
	public ObjectMapper objectMapper;
	
	
	private final String[] SCOPES = new String[]{
		"https://www.googleapis.com/auth/userinfo.profile",
		"https://www.googleapis.com/auth/userinfo.email",
	};


	private final JsonFactory JSON_FACTORY = new JacksonFactory();
	private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	
	public String buildLoginUrl(String callback) {
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
				JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, Arrays.asList(SCOPES)).build();

		return flow.newAuthorizationUrl().setRedirectUri(CALLBACK_URI).build();
	}

	/**
	  * @Method Name : getUserInfoJson
	  * @Date : 2016. 6. 30.
	  * @author : Kim YJ
	  * @comment 설명 : 사용자 정보 호출(JSON방식)
	  * @param response : 리턴된 토큰값
	  * @throws IOException
	  */
	public GoogleUser getUserInfoJson(String authCode) throws IOException {
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
				JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, Arrays.asList(SCOPES)).build();

		GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(CALLBACK_URI).execute();
		Credential credential = flow.createAndStoreCredential(response, null);
		HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);

		HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(USER_INFO_URL));

		request.getHeaders().setContentType("application/json");
		final String jsonIdentity = request.execute().parseAsString();

		return objectMapper.readValue(jsonIdentity, GoogleUser.class);
	}

	public String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}

	public String getCLIENT_SECRET() {
		return CLIENT_SECRET;
	}

	public void setCLIENT_SECRET(String cLIENT_SECRET) {
		CLIENT_SECRET = cLIENT_SECRET;
	}

	public String getUSER_INFO_URL() {
		return USER_INFO_URL;
	}

	public void setUSER_INFO_URL(String uSER_INFO_URL) {
		USER_INFO_URL = uSER_INFO_URL;
	}
	
	public String getCALLBACK_URI() {
		return CALLBACK_URI;
	}

	public void setCALLBACK_URI(String cALLBACK_URI) {
		CALLBACK_URI = cALLBACK_URI;
	}
	
}
