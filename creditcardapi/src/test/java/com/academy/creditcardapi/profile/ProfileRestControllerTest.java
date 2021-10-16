package com.academy.creditcardapi.profile;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileRestControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProfileService profileService;

  @Rule //initMocks
  public MockitoRule rule = MockitoJUnit.rule();  

  @Test
  public void shouldReturnErrorWithNoParametersOnURL() throws Exception {
    mvc.perform(get("/profile"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void shouldReturnErrorWithNonExistingInformationOnURL() throws Exception {
    mvc.perform(get("/profile?information=doesnt exist"))
        .andExpect(status().isNotFound());
  }

  @Test
  public void shouldReturnBsmartAfinityCardWithShopping18And7500OnURL() throws Exception {
 
    String passion = "Shopping";
    Integer age = 18;
    Double salary = 7500.00;

    String creditcards = "B•Smart, Afinity Card";

    when(profileService.getCreditCardsByCustomerInfo(passion, age, salary)).thenReturn(creditcards);

    mvc.perform(get("/profile?information=Shopping,18,7500")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$[0].profile").value(creditcards))
        .andExpect(status().isOk());
  }

}
