package com.app.mydaybook.daily.application.ports.input;

import java.time.LocalDate;
import java.util.List;

public interface IDailyTaskQueryService {
    public List<Long> getDoneTasksByDate(Long userId, LocalDate date);
}
