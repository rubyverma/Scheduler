package com.scheduler.models;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	private int categoryId;
	private int officialId;
	private String categoryName;
	private List<Faq> faqs;
}
