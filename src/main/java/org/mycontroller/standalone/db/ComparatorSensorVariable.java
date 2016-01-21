package org.mycontroller.standalone.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.mycontroller.standalone.MYCMessages.MESSAGE_TYPE_SET_REQ;
import org.mycontroller.standalone.db.tables.SensorVariable;

public class ComparatorSensorVariable implements Comparator<SensorVariable> {

    //Using this we can sort variable in order, will help to display on GUI action board in order
    public static final List<MESSAGE_TYPE_SET_REQ> VARIABLE_ORDER = new ArrayList<MESSAGE_TYPE_SET_REQ>();

    static {
        VARIABLE_ORDER.addAll(
                Arrays.asList(
                        MESSAGE_TYPE_SET_REQ.V_STATUS,
                        MESSAGE_TYPE_SET_REQ.V_ARMED,
                        MESSAGE_TYPE_SET_REQ.V_TRIPPED,
                        MESSAGE_TYPE_SET_REQ.V_DOWN,
                        MESSAGE_TYPE_SET_REQ.V_UP,
                        MESSAGE_TYPE_SET_REQ.V_STOP,
                        MESSAGE_TYPE_SET_REQ.V_LOCK_STATUS,
                        MESSAGE_TYPE_SET_REQ.V_HVAC_FLOW_STATE,
                        MESSAGE_TYPE_SET_REQ.V_HVAC_FLOW_MODE,
                        MESSAGE_TYPE_SET_REQ.V_HVAC_SPEED,
                        MESSAGE_TYPE_SET_REQ.V_HVAC_SETPOINT_COOL,
                        MESSAGE_TYPE_SET_REQ.V_HVAC_SETPOINT_HEAT,
                        MESSAGE_TYPE_SET_REQ.V_TEMP,
                        MESSAGE_TYPE_SET_REQ.V_SCENE_ON,
                        MESSAGE_TYPE_SET_REQ.V_SCENE_OFF,
                        MESSAGE_TYPE_SET_REQ.V_VOLTAGE,
                        MESSAGE_TYPE_SET_REQ.V_CURRENT,
                        MESSAGE_TYPE_SET_REQ.V_HUM,
                        MESSAGE_TYPE_SET_REQ.V_PERCENTAGE,
                        MESSAGE_TYPE_SET_REQ.V_LEVEL,
                        MESSAGE_TYPE_SET_REQ.V_IR_SEND,
                        MESSAGE_TYPE_SET_REQ.V_IR_RECEIVE,
                        MESSAGE_TYPE_SET_REQ.V_RGB,
                        MESSAGE_TYPE_SET_REQ.V_RGBW,
                        MESSAGE_TYPE_SET_REQ.V_LIGHT_LEVEL,
                        MESSAGE_TYPE_SET_REQ.V_IMPEDANCE,
                        MESSAGE_TYPE_SET_REQ.V_DISTANCE,
                        MESSAGE_TYPE_SET_REQ.V_WATT));
        //Add remaining variable types into list
        for (MESSAGE_TYPE_SET_REQ variableType : MESSAGE_TYPE_SET_REQ.values()) {
            if (!VARIABLE_ORDER.contains(variableType)) {
                VARIABLE_ORDER.add(variableType);
            }
        }
    }

    @Override
    public int compare(SensorVariable variable1, SensorVariable variable2) {
        if (VARIABLE_ORDER.indexOf(variable1.getVariableType()) > VARIABLE_ORDER.indexOf(variable2.getVariableType())) {
            return 1;
        } else if (VARIABLE_ORDER.indexOf(variable1.getVariableType()) < VARIABLE_ORDER.indexOf(variable2
                .getVariableType())) {
            return -1;
        } else {
            return 0;
        }
    }

}
