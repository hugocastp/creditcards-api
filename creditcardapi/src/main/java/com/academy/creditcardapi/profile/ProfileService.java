package com.academy.creditcardapi.profile;

import com.academy.creditcardapi.creditcard.CreditCardRepository;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProfileService {

  @Autowired
  private CreditCardRepository creditCardRepository;


  public String getCreditCardsByCustomerInfo(String passion, Integer age, Double salary) throws JsonParseException, IOException {
    if ( passion == null || age == null || salary == null) {
      return new String();
    }
    return creditCardRepository.findCreditCardByCustomerInfo(passion, age, salary);
  }
}
