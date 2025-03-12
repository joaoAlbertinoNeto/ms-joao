package br.com.joao.ms_joao.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Util {

    public static class CustomTimer{
        public static String timeNow(){
            var data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
            return data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss"));
        }

    }
}
