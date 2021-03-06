/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package avalon.mysql.proto;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Com_Dropdb extends Packet {
    public String schema = "";

    public ArrayList<byte[]> getPayload() {
        ArrayList<byte[]> payload = new ArrayList<byte[]>();

        payload.add(Proto.build_byte(Flags.COM_DROP_DB));
        payload.add(Proto.build_fixed_str(this.schema.length(), this.schema));

        return payload;
    }

    public static Com_Dropdb loadFromPacket(byte[] packet) {
        Com_Dropdb obj = new Com_Dropdb();
        Proto proto = new Proto(packet, 3);

        obj.sequenceId = proto.get_fixed_int(1);
        proto.get_filler(1);
        obj.schema = proto.get_eop_str();

        return obj;
    }
}
