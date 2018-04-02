package com.example.ishanpant.skilllearn;

import android.content.res.AssetManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

@RunWith(AndroidJUnit4.class)
public class WireMockTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(1111);

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void test() throws Exception {
        stubFor(get(urlMatching("/v2/5ab3b7412f00006600ca391c"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("response.json")));
    }
}
