package org.example.item;

import lombok.*;

@Data
@Builder
public class Item {

    // DTO
    private long item_id;   // 자동증가..
	private String reg_time;    //현재시간..
	private String update_time;  // 수정시간..

    private String item_nm;
    private String item_detail;
    private String item_sell_status;
    private int price;
	private int stock_number;

}
