package com.app.mydaybook.activities.domain.enums;

public enum Emotion {
    ABATIDO("Abatido"), // Representa un estado de tristeza o desesperanza extrema.
    ANXIOUS("Ansioso"), // Emoción de preocupación o estrés constante.
    IRRITATED("Irritado"), // Estado de enojo leve o molestia.
    FRUSTRATED("Frustrado"), // Sensación de impedimento o insatisfacción.
    UNMOTIVATED("Desmotivado"), // Falta de energía o interés para actuar.
    NEUTRAL("Neutral"), // Sin emociones fuertes, en un punto intermedio.
    OPTIMISTIC("Optimista"), // Sentimiento positivo sobre lo que está por venir.
    HAPPY("Contento"), // Sensación general de bienestar.
    EXCITED("Emocionado"), // Alegría o entusiasmo elevado por algo específico.
    EUPHORIC("Eufórico"); // Estado extremo de felicidad y emoción.

    private final String spanishName;

    Emotion(String spanishName) {
        this.spanishName = spanishName;
    }

    public String getSpanishName() {
        return spanishName;
    }
}
