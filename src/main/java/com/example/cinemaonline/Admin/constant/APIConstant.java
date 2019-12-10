package com.example.cinemaonline.Admin.constant;

public interface APIConstant {

	String BASE_API = "/admin";

	String TIN_TUC = BASE_API + "/news";
	String HE_THONG_RAP = BASE_API + "/hethongrap";
	String LIST_RAP = BASE_API + "/danhsachrap";
	String LIST_PHIM = BASE_API + "/danhsachphim";
	String NGAY_CHIEU = LIST_PHIM + "/ngaychieu";
	String SUAT_CHIEU = LIST_PHIM + "/suatchieu";
	String SEAT_MAP = LIST_PHIM + "/seatmap";

	String ACCOUNT = BASE_API + "/account";
}
