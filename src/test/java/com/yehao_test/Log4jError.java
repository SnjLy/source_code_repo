package com.yehao_test;

import lombok.extern.slf4j.Slf4j;

import javax.management.RuntimeErrorException;

/**
 * com.yehao_test
 *
 * @author: SNJly
 * @date: 2019-07-23
 */
@Slf4j
public class Log4jError {

    public static void main(String[] args) {

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("1:不能除以0" +e);
        }
        try {
            throw new Exception("常见错误");
        } catch (Exception e) {
            log.error("2:常见问题", e);
        }

        try {
            throw new RuntimeException("常见异常RuntimeException");
        } catch (Exception e) {
            log.error("3:常见异常{}","RuntimeException", e);
        }

        try {
            throw new NullPointerException();
        } catch (Exception e) {
            log.error("4:常见问题{}, error:{}","NullPointerException", e);
        }

        try {
            throw new NullPointerException();
        } catch (Exception e) {
            log.error("5:常见空指针{}, data:{}","NullPointerException", null, e);
        }


        try {
            throw new NullPointerException();
        } catch (Exception e) {
            log.error("6:又见空指针{}, data:{}， error:{}","NullPointerException", null, e);
        }
    }


}
