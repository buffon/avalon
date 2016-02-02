/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package avalon.mysql.proto;

import org.junit.*;

import static org.junit.Assert.*;

public class HandshakeTest {
    @Test
    public void test_5_5_2() {
        // https://dev.mysql.com/doc/internals/en/connection-phase-packets.html#packet-Protocol::Handshake
        byte[] packet = new byte[]{
                (byte) 0x36, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x0a, (byte) 0x35, (byte) 0x2e, (byte) 0x35,
                (byte) 0x2e, (byte) 0x32, (byte) 0x2d, (byte) 0x6d, (byte) 0x32, (byte) 0x00, (byte) 0x0b, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x64, (byte) 0x76, (byte) 0x48, (byte) 0x40, (byte) 0x49, (byte) 0x2d,
                (byte) 0x43, (byte) 0x4a, (byte) 0x00, (byte) 0xff, (byte) 0xf7, (byte) 0x08, (byte) 0x02, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x2a, (byte) 0x34, (byte) 0x64,
                (byte) 0x7c, (byte) 0x63, (byte) 0x5a, (byte) 0x77, (byte) 0x6b, (byte) 0x34, (byte) 0x5e, (byte) 0x5d,
                (byte) 0x3a, (byte) 0x00
        };
        assertArrayEquals(packet, Handshake.loadFromPacket(packet).toPacket());
    }

    @Test
    public void test_5_6_4() {
        // https://dev.mysql.com/doc/internals/en/connection-phase-packets.html#packet-Protocol::Handshake
        byte[] packet = new byte[]{
                (byte) 0x50, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x0a, (byte) 0x35, (byte) 0x2e, (byte) 0x36,
                (byte) 0x2e, (byte) 0x34, (byte) 0x2d, (byte) 0x6d, (byte) 0x37, (byte) 0x2d, (byte) 0x6c, (byte) 0x6f,
                (byte) 0x67, (byte) 0x00, (byte) 0x56, (byte) 0x0a, (byte) 0x00, (byte) 0x00, (byte) 0x52, (byte) 0x42,
                (byte) 0x33, (byte) 0x76, (byte) 0x7a, (byte) 0x26, (byte) 0x47, (byte) 0x72, (byte) 0x00, (byte) 0xff,
                (byte) 0xff, (byte) 0x08, (byte) 0x02, (byte) 0x00, (byte) 0x0f, (byte) 0xc0, (byte) 0x15, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x2b, (byte) 0x79, (byte) 0x44, (byte) 0x26, (byte) 0x2f, (byte) 0x5a, (byte) 0x5a,
                (byte) 0x33, (byte) 0x30, (byte) 0x35, (byte) 0x5a, (byte) 0x47, (byte) 0x00, (byte) 0x6d, (byte) 0x79,
                (byte) 0x73, (byte) 0x71, (byte) 0x6c, (byte) 0x5f, (byte) 0x6e, (byte) 0x61, (byte) 0x74, (byte) 0x69,
                (byte) 0x76, (byte) 0x65, (byte) 0x5f, (byte) 0x70, (byte) 0x61, (byte) 0x73, (byte) 0x73, (byte) 0x77,
                (byte) 0x6f, (byte) 0x72, (byte) 0x64, (byte) 0x00
        };
        assertArrayEquals(packet, Handshake.loadFromPacket(packet).toPacket());
    }
}
