/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.java.enums;

/**
 *
 * @author AnChuPC
 */
public enum ArticleType {
    CHINH_QUY, // hệ chính quy
    LIEN_THONG, // hệ liên thông
    CAO_HOC, // hệ cao học,
    THAC_SI, // hệ thạc sĩ,
    TU_XA, // đào tạo từ xa
    KHOA; // thông tin khoa
    public static String convertToString(ArticleType type) {
        if (type == CHINH_QUY) {
            return "THÔNG TIN TUYỂN SINH ĐẠI HỌC CHÍNH QUY";
        }
        if (type == LIEN_THONG) {
            return "THÔNG TIN TUYỂN SINH LIÊN THÔNG CĐ-ĐH";
        }
        if (type == CAO_HOC) {
            return "THÔNG TIN TUYỂN SINH CAO HỌC";
        }
        if (type == THAC_SI) {
            return "THÔNG TIN TUYỂN SINH THẠC SĨ";
        }
        if (type == TU_XA) {
            return "THÔNG TIN TUYỂN SINH TỪ XA";
        }
        if (type == KHOA){
            return "THÔNG TIN KHOA";
        }

        return "Không có tiêu đề phù hợp";
    }
}
