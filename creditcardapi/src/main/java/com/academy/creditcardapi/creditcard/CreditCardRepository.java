package com.academy.creditcardapi.creditcard;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CreditCardRepository {

  @Autowired
  private ObjectMapper objectMapper;

  public List<CreditCard> findAll() {
    try {
      InputStream creditCardJson = CreditCardWrapper.class.getResourceAsStream("/creditcards.json");
      CreditCardWrapper creditCardWrapper = objectMapper.readValue(creditCardJson, new TypeReference<CreditCardWrapper>() {
      });
      return creditCardWrapper.getCreditcards();

    } catch (IOException exception) {
      System.out.println("Error:" + exception.getMessage() + " " + exception.getCause() + exception.getStackTrace());
    }
    return new ArrayList<>();
  }

  public String findCreditCardByCustomerInfo(String passion, Integer age, Double salary) throws JsonParseException, IOException, JsonParseException {
    
    List<CreditCard> creditCardList  = new ArrayList<>();

    for (CreditCard creditCard : findAll()) {
      int retvalLow = Double.compare(salary, creditCard.getSalary_low());
      int retvalHigh = Double.compare(salary, creditCard.getSalary_high());
      // 0 if salary == creditCard.getSalary(); 
      // < 0 if salary is < creditCard.getSalary(); 
      // > 0 if salary is > creditCard.getSalary();
        boolean salaryGreaterThan = false;

        if(Double.compare(creditCard.getSalary_low(), creditCard.getSalary_high()) == 0) {
            salaryGreaterThan = true;
        }

      if (salaryGreaterThan && creditCard.getPassion().equalsIgnoreCase(passion) && ( age <= creditCard.getAge_high() && age >= creditCard.getAge_low()) && (retvalLow >= 0) ) {
        creditCardList.add(creditCard);

      }else if (!salaryGreaterThan && creditCard.getPassion().equalsIgnoreCase(passion) && ( age <= creditCard.getAge_high() && age >= creditCard.getAge_low()) && ((retvalLow >= 0 && retvalHigh <= 0)) ) {
        creditCardList.add(creditCard);
      }
    }
    CreditCard aux = creditCardList.get(0);
    
    return aux.getProfile();
  }

}
