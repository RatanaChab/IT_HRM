package com.example.IT_HRM.Utils;

import com.example.IT_HRM.DTO.BankCodeDTO;
import com.example.IT_HRM.GlobalException.DataIntegrityException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommonUse {

    public static String extractDuplicateKeyDetail(String errorMessage) {
        Pattern pattern = Pattern.compile("Detail: (Key \\(.*?\\)=\\(.*?\\) already exists\\.)");
        Matcher matcher = pattern.matcher(errorMessage);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Duplicate key detail not found.";
    }


    public static <T, U extends Comparable<? super U>> List<T> sortByField(List<T> list, Function<T, U> fieldExtractor) {
        return list.stream()
                .sorted(Comparator.comparing(item -> fieldExtractor.apply(item))).toList();
    }

    public static <T> void checkDuplicates( List<T> list, Function<T, String> keyExtractor){

        Map<String, List<T>> grouped = list.stream().collect(Collectors.groupingBy(keyExtractor));
        grouped.forEach((key, group) -> {
            if(group.size() == 1){
                System.out.println("Duplicate found for: " + key);
                throw new DataIntegrityException("Duplicate",key);
            }
        });

    }

}
