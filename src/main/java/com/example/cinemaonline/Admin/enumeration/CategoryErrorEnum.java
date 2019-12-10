package com.example.cinemaonline.Admin.enumeration;

public enum CategoryErrorEnum {
	
	TIN_TUC_EXISTED ("exception_400", "Bảng mã CDHA đã tồn tại."),
	TIN_TUC_NOT_FOUND ("exception_404", "Không tìm thấy bảng mã CDHA, kiểm tra lại mã");

	private final String code;
    private final String desc;

    CategoryErrorEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode () {
        return code;
    }

    public String getDescription () {
        return desc;
    }

}
