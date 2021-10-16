package com.academy.creditcardapi.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class CreditCard  {
  private String profile;
  private String passion;
  @JsonProperty("salary-low")
  private Double salary_low;
  @JsonProperty("salary-high")
  private Double salary_high;
  @JsonProperty("age-low")
  private Integer age_low;
  @JsonProperty("age-high")
  private Integer age_high;

  public CreditCard() {}

  public CreditCard(String profile, String passion, Double salary_low, Double salary_high, Integer age_low, Integer age_high) {
    this.profile = profile;
    this.passion = passion;
    this.salary_low = salary_low;
    this.salary_high = salary_high;
    this.age_low = age_low;
    this.age_high = age_high;
  }


}
