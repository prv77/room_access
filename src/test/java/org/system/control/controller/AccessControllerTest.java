package org.system.control.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccessControllerTest extends AbstractControllerTest {
    ResultActions result;
    String response;

    @Test
    void checkEntrance() throws Exception {
        result = getRequestParameters("1", true, "1");
        response = getResponse(result);
        assertEquals("200", response);

        result = getRequestParameters("1", true, "1");
        response = getResponse(result);
        assertEquals("403", response);

        result = getRequestParameters("1", false, "1");
        response = getResponse(result);
        assertEquals("200", response);

        result = getRequestParameters("1", false, "1");
        response = getResponse(result);
        assertEquals("403", response);
    }

    @Test
    void checkLimits() throws Exception {
        result = getRequestParameters("3", true, "6");
        response = getResponse(result);
        assertEquals("200", response);

        result = getRequestParameters("3", true, "7");
        response = getResponse(result);
        assertEquals("403", response);

        result = getRequestParameters("0", true, "0");
        response = getResponse(result);
        assertEquals("403", response);

        result = getRequestParameters("0", true, "10001");
        response = getResponse(result);
        assertEquals("403", response);
    }

    private ResultActions getRequestParameters(String roomId, boolean entrance, String keyId) throws Exception {
        return perform(MockMvcRequestBuilders.get("/check")
                .queryParam("roomId", roomId)
                .queryParam("entrance", String.valueOf(entrance))
                .queryParam("keyId", keyId)
        );
    }

    private String getResponse(ResultActions result) throws Exception {
        return result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
                .andReturn().getResponse().getContentAsString();
    }
}