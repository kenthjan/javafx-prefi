package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;
    private Timeline timeline;

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    @FXML
    public void initialize() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play(); // Start the timeline
        updateLights(); // Set initial light
    }

    /// Called every 3 seconds
    public void onTimerChange() {
        switch (currentColor) {
            case STOP:
                currentColor = TrafficLightColor.GO;
                break;
            case GO:
                currentColor = TrafficLightColor.HOLD;
                break;
            case HOLD:
                currentColor = TrafficLightColor.STOP;
                break;
        }
        updateLights();
    }

    private void updateLights() {
        redLight.setFill(currentColor == TrafficLightColor.STOP ? Color.RED : Color.DARKRED);
        yellowLight.setFill(currentColor == TrafficLightColor.HOLD ? Color.YELLOW : Color.DARKGOLDENROD);
        greenLight.setFill(currentColor == TrafficLightColor.GO ? Color.LIMEGREEN : Color.DARKGREEN);
    }
}
