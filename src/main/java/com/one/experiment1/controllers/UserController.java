package com.one.experiment1.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.experiment1.dtos.User;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;

@RestController
@RequestMapping("/")
public class UserController {

  final Logger logger = LoggerFactory.getLogger(UserController.class);
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("user")
  public String addUserToDB() {

    String sql = "INSERT INTO students (name) VALUES ('sam');";
    jdbcTemplate.update(sql);
    return "Success";
  }

//  @GetMapping("data")
//  public String getData() {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      File file = new File("C:\\Users\\venkatesh\\Documents\\workspace\\java-tutorials\\a.json");
//      Object object = mapper.readValue(file, User.class);
//      return  object.toString();
//
//    } catch (Exception e) {
//      logger.error("Exception ==> ", e);
//    }
//    return "";
//  }

  @GetMapping("data")
  public String getData() throws Exception {
    try {
      JSONParser jsonParser = new JSONParser();
      Object obj = jsonParser.parse(new FileReader("C:\\Users\\venkatesh\\Documents\\workspace\\java-tutorials\\a.json"));
      logger.info("===" + obj);
      return obj.toString();
    } catch (Exception e) {
      logger.error("Exception ==> ", e);
      throw new Exception("exception");
    }
  }
}
