package com.academy.creditcardapi.profile;

import com.fasterxml.jackson.core.JsonParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/profile")
@RestController
public class ProfileRestController {

  @Autowired
  private ProfileService profileService;

  @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
  public @ResponseBody
  ResponseEntity<String> getCreditCardsByCustomerInfo(@RequestParam(name = "information") List<String> customerInfo) throws JsonParseException, NumberFormatException, IOException {
    final String creditcards = profileService.getCreditCardsByCustomerInfo(customerInfo.get(0), Integer.parseInt(customerInfo.get(1)), Double.parseDouble(customerInfo.get(2)));
  
    if (null == creditcards || creditcards.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(creditcards, HttpStatus.OK);
  }
}