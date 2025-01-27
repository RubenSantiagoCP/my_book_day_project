package com.app.mydaybook.daily.application.ports.output;

import java.time.LocalDate;
import java.util.List;

public interface IDailyTaskQueryPersistentPort {
    public List<Long> getDoneTasksByDate(Long userId, LocalDate date);

}
