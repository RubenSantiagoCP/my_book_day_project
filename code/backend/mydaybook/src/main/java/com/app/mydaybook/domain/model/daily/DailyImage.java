package com.app.mydaybook.domain.model.daily;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class DailyImage {
    private Long id;
    private DailyRecord dailyRecord;
    private String imageURL;
    private String description;
    private Date uploadAt;
}
