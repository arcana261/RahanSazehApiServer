package com.rahansazeh.apiserver.utils;

//import com.rahansazeh.apiserver.model.LicensePlate;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class LicensePlateFormatter {
//    private LicensePlateFormatter() {
//    }
//
//    public static LicensePlate parseLicensePlate(String s) {
//        String[] parts = Arrays.stream(s.split("\\D"))
//                .filter(str -> str.length() > 0)
//                .collect(Collectors.toList())
//                .toArray(new String[0]);
//
//        String left = "";
//        String right = "";
//        String national = "";
//        String type = "";
//
//        if (parts.length == 2) {
//            if (parts[0].length() == 2) {
//                left = parts[0];
//
//                if (parts[1].length() == 3) {
//                    right = parts[1];
//                    national = "00";
//                } else if (parts[1].length() == 5) {
//                    right = parts[1].substring(0, 3);
//                    national = parts[1].substring(3);
//                }
//            } else if (parts[0].length() == 3) {
//                right = parts[0];
//
//                if (parts[1].length() == 2) {
//                    left = parts[1];
//                    national = "00";
//                } else if (parts[1].length() == 4) {
//                    left = parts[1].substring(0, 2);
//                    national = parts[1].substring(2);
//                }
//            } else if (parts[0].length() == 4) {
//                left = parts[0].substring(0, 2);
//                national = parts[0].substring(2);
//
//                if (parts[1].length() == 3) {
//                    right = parts[1];
//                }
//            } else if (parts[0].length() == 5) {
//                right = parts[0].substring(0, 3);
//                national = parts[0].substring(3);
//
//                if (parts[0].length() == 2) {
//                    left = parts[0];
//                }
//            }
//        } else if (parts.length == 3) {
//            if (parts[0].length() == 2 && parts[1].length() == 3 && parts[2].length() == 2) {
//                national = parts[0];
//                right = parts[1];
//                left = parts[2];
//            }
//        }
//
//        parts = Arrays.stream(s.split("\\d"))
//                .map(str -> str.trim())
//                .filter(str -> str.length() > 0)
//                .collect(Collectors.toList())
//                .toArray(new String[0]);
//
//        if (parts.length == 1 && parts[0].length() == 1) {
//            type = parts[0];
//        }
//
//        if (left.length() != 2 || right.length() != 3 || national.length() != 2 || type.length() != 1) {
//            throw new IllegalArgumentException("invalid format");
//        }
//
//        return new LicensePlate(Integer.parseInt(left), type.charAt(0),
//                Integer.parseInt(right), Integer.parseInt(national));
//    }
//}
