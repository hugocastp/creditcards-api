package com.academy.creditcardapi.creditcard;

import java.util.List;
import lombok.Data;


@Data
public class CreditCardWrapper {
  private List<CreditCard> creditcards;

  public CreditCardWrapper() {
  }

  public CreditCardWrapper(List<CreditCard> creditcards) {
    this.creditcards = creditcards;
  }


}
