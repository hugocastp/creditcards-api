package com.academy.creditcardapi.profile;

import com.academy.creditcardapi.creditcard.CreditCard;
import com.academy.creditcardapi.creditcard.CreditCardRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ProfileServiceTest {
  @Mock
  CreditCardRepository creditCardRepository;

  @InjectMocks
  ProfileService profileService;

  @Rule // initMocks
  public MockitoRule rule = MockitoJUnit.rule();

  @Test
  public void shouldReturnPlatinumWithTravels45And50000Parameters() throws IOException{
    when(creditCardRepository.findCreditCardByCustomerInfo("Travels", 45, 50000.00)).thenReturn("Platinum");

    when(creditCardRepository.findAll())
        .thenReturn(Arrays.asList(new CreditCard("Platinum","Travels", 50000.00, 50000.00, 23, 75 )));

    when(creditCardRepository.findCreditCardByCustomerInfo("Travels", 45, 50000.00))
        .thenReturn((new String("Platinum")));

    String resultCreditCard = profileService.getCreditCardsByCustomerInfo("Travels", 45, 50000.00);

    assertThat(resultCreditCard, is("Platinum"));
  }
}
