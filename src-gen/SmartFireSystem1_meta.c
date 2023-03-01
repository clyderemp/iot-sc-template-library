/** Generated by itemis CREATE code generator. */

#include "SmartFireSystem1_meta.h"
		
sc_string SmartFireSystem1_meta_feature_names[] = {
	"<nothing>",
	"toggle",
	"on",
	"off",
	"Timer.enable",
	"Timer.disable",
	"Timer.reset",
	"Timer.counter",
	"Timer.warning_period",
	"Timer.final_warning_period",
	"Timer.color",
	"Power.kilowatt",
	"Message.status",
	"Message.sensor",
	"Mode.manual_alarm_off",
	"Mode.manual_alarm_on",
	"Mode.safe",
	"Mode.warning",
	"Mode.final_warning",
	"Mode.danger",
	"Alarm.threshold_reached",
	"Alarm.sound",
	"Sensors.smoke",
	"Sensors.carbon",
	"Sensors.fire",
	"Sensors.smoke_standby",
	"Sensors.carbon_standby",
	"Sensors.fire_standby",
	"Sensors.smoke_value",
	"Sensors.carbon_value",
	"Sensors.smoke_threshold",
	"Sensors.carbon_threshold",
	"Detect.smoke",
	"Detect.carbon",
	"Detect.both",
	"Detect.smokeDetected",
	"Detect.carbonDetected",
	"local_Mode_warning",
	"local_Mode_danger",
	"local_Mode_safe"
};

sc_string SmartFireSystem1_meta_state_names[] = {
	"<nostate>",
	"main_region.smartFireSystem_standby",
	"main_region.smartFireSystem_standby.MainSystem.Safe",
	"main_region.smartFireSystem_standby.MainSystem.Warning",
	"main_region.smartFireSystem_standby.MainSystem.Warning.mode.initial_warning",
	"main_region.smartFireSystem_standby.MainSystem.Warning.mode.final_warning",
	"main_region.smartFireSystem_standby.MainSystem.Danger",
	"main_region.smartFireSystem_standby.MainSystem.Danger.mode._911_emergency",
	"main_region.smartFireSystem_standby.Sensors.sensorsActive",
	"main_region.smartFireSystem_standby.Sensors.sensorsActive.smokeSensor.smokeSensing",
	"main_region.smartFireSystem_standby.Sensors.sensorsActive.smokeSensor.smokeStandby",
	"main_region.smartFireSystem_standby.Sensors.sensorsActive.carbonSensor.carbonSensing",
	"main_region.smartFireSystem_standby.Sensors.sensorsActive.carbonSensor.carbonStandby",
	"main_region.smartFireSystem_standby.Sensors.ThresholdReached",
	"main_region.smartFireSystem_standby.Sensors.ThresholdReached.warning_before_sounding.SensorWarning",
	"main_region.smartFireSystem_standby.Sensors.ThresholdReached.warning_before_sounding.SoundAlarm",
	"main_region.smartFireSystem_standby.Sensors.initialize",
	"main_region.smartFireSystem_standby.Timer.disabled",
	"main_region.smartFireSystem_standby.Timer.running",
	"main_region.smartFireSystem_standby.Timer.running.running.Red",
	"main_region.smartFireSystem_standby.Timer.running.running.Orange",
	"main_region.smartFireSystem_standby.Environment.normal",
	"main_region.smartFireSystem_standby.Environment.SmokeDetected",
	"main_region.smartFireSystem_standby.Environment.CarbonDetected",
	"main_region.smartFireSystem_standby.Environment.SmokeAndCarbonDetected"
};
