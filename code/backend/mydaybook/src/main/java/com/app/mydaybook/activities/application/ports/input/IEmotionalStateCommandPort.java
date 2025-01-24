package com.app.mydaybook.activities.application.ports.input;

import com.app.mydaybook.activities.domain.model.EmotionalState;

public interface IEmotionalStateCommandPort {
    public EmotionalState createEmotionalState(EmotionalState emotionalState);
    public EmotionalState updaEmotionalState(Long id, EmotionalState emotionalState);
    public boolean deleteEmotionalState(Long id);
}
