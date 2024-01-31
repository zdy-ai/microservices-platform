package com.example.workdemo.util;

import com.example.workdemo.model.PersonDTO;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author zdy
 * @ClassName LamdbaUtil
 * @description: TODO
 * @date 2024年01月26日
 * @version: 1.0
 */
public class LamdbaUtil {
    public static void main(String[] args) {
        Map<String, List<PersonDTO>> map = new HashMap<>();
        List<PersonDTO> personDTOS = new ArrayList<>(3);
        personDTOS.add(PersonDTO.builder().id("1").age("10").price(null).build());
//        personDTOS.add(PersonDTO.builder().id("1").age("10").price(new BigDecimal(1)).build());
//        personDTOS.add(PersonDTO.builder().id("2").age("11").price(new BigDecimal(2)).build());
//        personDTOS.add(PersonDTO.builder().id("3").age("12").price(new BigDecimal(3)).build());
        map.put("1",personDTOS);
//
//        List<PersonDTO> personDTOS2 = new ArrayList<>(3);
//        personDTOS2.add(PersonDTO.builder().id("4").age("10").price(new BigDecimal(4)).build());
//        personDTOS2.add(PersonDTO.builder().id("5").age("11").price(new BigDecimal(5)).build());
//        personDTOS2.add(PersonDTO.builder().id("6").age("12").price(new BigDecimal(6)).build());
//        map.put("2",personDTOS2);
//
//        List<PersonDTO> personDTOS3 = new ArrayList<>(3);
//        personDTOS3.add(PersonDTO.builder().id("7").age("10").price(new BigDecimal(7)).build());
//        personDTOS3.add(PersonDTO.builder().id("8").age("11").price(new BigDecimal(8)).build());
//        personDTOS3.add(PersonDTO.builder().id("9").age("12").price(new BigDecimal(9)).build());
//        map.put("3",personDTOS3);

        BigDecimal maxLength = map.values().stream().flatMap(List::stream).filter(e -> Objects.nonNull(e.getPrice())).max(Comparator.comparing(PersonDTO::getPrice)).orElse(new PersonDTO()).getPrice();
        System.out.println("maxLength:"+ maxLength);
        BigDecimal total = map.values().stream().flatMap(List::stream).filter(e -> Objects.nonNull(e.getPrice())).map(PersonDTO::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        System.out.println("total:"+ total);


    }
}
