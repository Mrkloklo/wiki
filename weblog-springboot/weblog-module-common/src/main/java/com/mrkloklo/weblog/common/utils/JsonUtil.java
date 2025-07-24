package com.mrkloklo.weblog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gujhao
 * @date 2025年7月22日16:32:26
 * @description JSON 工具类
 */
@Slf4j
public class JsonUtil {
 private static final ObjectMapper INSTANCE  = new ObjectMapper();

 public static String toJsonString(Object obj) {
   try {
       return INSTANCE.writeValueAsString(obj);
   } catch (JsonProcessingException  e) {
      return obj.toString();
   }
 }
}
