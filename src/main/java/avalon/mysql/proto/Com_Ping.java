/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package avalon.mysql.proto;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Com_Ping extends Packet {

    public ArrayList<byte[]> getPayload() {
        ArrayList<byte[]> payload = new ArrayList<byte[]>();

        payload.add(Proto.build_byte(Flags.COM_PING));

        return payload;
    }

    public static Com_Ping loadFromPacket(byte[] packet) {
        Com_Ping obj = new Com_Ping();
        Proto proto = new Proto(packet, 3);

        obj.sequenceId = proto.get_fixed_int(1);

        return obj;
    }
}
